/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.SensorData;
import com.model.TherapistUser;
import com.reader.CSVReader;
import com.service.TherapistService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tomas
 */
@Controller
@RequestMapping(value = "/homescreen")
public class HomescreenController {

    @Autowired
    private TherapistService therapistService;

    @RequestMapping(value = "/")
    public ModelAndView login(HttpSession session, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "password", required = false) String password) throws IOException {
        if (session.getAttribute("therapist") != null) {
            return new ModelAndView("homescreen/home");
        }
        TherapistUser therapist = therapistService.getTherapist(email, password);
        ModelAndView mav = new ModelAndView("index");
        if (therapist != null) {
            session.setAttribute("therapist", therapist);
            mav = new ModelAndView("homescreen/home");
        }

        return mav;

    }

    @RequestMapping(value = "/home")
    public ModelAndView index(HttpSession session) {
        if (session.getAttribute("therapist") == null) {
            return new ModelAndView("index");
        }
        ModelAndView view = new ModelAndView("homescreen/home");
        return view;
    }

    @RequestMapping(value = "/dataTest")
    public ModelAndView dataTest() {
        File file = new File("C:/Users/tom/documents/csvData/Knie strekken.csv");
        InputStream is = null;
        try {
            is = new FileInputStream("C:/Users/tom/documents/csvData/Knie strekken.csv");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Set stream to Reader
        Reader reader = new InputStreamReader(is);
        CSVReader csv = new CSVReader(reader, SensorData.class);
//        MovingAverage ma = new MovingAverage(10);

        // Deserialize the stream
        csv.deserialize();

        // Get deserialized Items
        List<SensorData> data = csv.getItems();

        double[] xs = new double[data.size()];
        double[] ys = new double[data.size()];
        double[] zs = new double[data.size()];

        //Loop and print the items
        for (int i = 0; i < data.size(); i++) {
            xs[i] = data.get(i).getX();
            ys[i] = data.get(i).getY();
            zs[i] = data.get(i).getZ();
        }

        int windowSize = 10;
        double[] awesomeArray = movingAvg(xs, windowSize, new double[xs.length / windowSize + 1], 0, xs.length);

        ArrayList categories = new ArrayList();
        for (int i = 0; i < data.size(); i++) {
            categories.add(data.get(i).getTimestamp());
        }

        ArrayList al = new ArrayList();
        for (int i = 0; i < awesomeArray.length; i++) {
            al.add(awesomeArray[i]);
        }

        String csvdx = al.toString().replace("[", "").replace("]", "");
        String categorieX = categories.toString().replace("[", "").replace("]", "");

        System.out.println(categorieX);

        ModelAndView view = new ModelAndView("homescreen/home");

        view.addObject("chartDatax", csvdx);
        view.addObject("exnamex", file.getName().substring(0, file.getName().length() - 4));

        view.addObject("categorieX", categorieX);
        view.addObject("exnamey", file.getName());

        return view;
    }

    public double[] movingAvg(double[] a, int windowSize, double[] avgs, int avgIndex, int n) {
        int i = a.length / windowSize;
        int remainder = a.length % windowSize;
        int startIndex = a.length - n;

        double avg = 0;
        if (n < windowSize) {
            for (int j = 0; j < remainder; j++) {
                avg = avg + a[startIndex + j];
            }
            avgs[avgIndex] = avg / remainder;
            return avgs;
        } else {
            for (int j = 0; j < windowSize; j++) {
                avg = avg + a[startIndex + j];
            }
            avgs[avgIndex] = avg / windowSize;
            return movingAvg(a, windowSize, avgs, avgIndex + 1, n - windowSize);
        }
    }

    public int countPeaks(double[] a) {
        int counter = 1;
        int peaks = 0;
        double sig = 0;

        for (int i = 0; i < a.length - 1; i++) {
            if (i == 0) {
                sig = Math.signum(a[i] - a[i + 1]);
            } else {
                double oldSig = sig;
                sig = Math.signum(a[i] - a[i + 1]);
                if (oldSig == sig) {
                    counter++;
                } else {
                    if (counter >= 2) {
                        peaks++;
                    }
                    counter = 0;
                }
            }
        }
        return peaks;
    }

}
