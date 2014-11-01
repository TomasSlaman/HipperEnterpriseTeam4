/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Christiaaan
 */
public class GlobalVariables {
 
    static HttpSession session;

    public static HttpSession getSession() {
        return session;
    }

    public static void setSession(HttpSession session) {
        GlobalVariables.session = session;
    }
}
