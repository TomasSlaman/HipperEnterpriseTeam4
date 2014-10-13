/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    var height = $(window).height();
    $('.right-container').height(height);
    $('.left-container').height(height);

    var middleOfPage = height / 2;
    var heightLogin = $('.login-form').height();
    $('.login-form').css({'margin-top': middleOfPage - heightLogin + "px"});

    $('#login-form').validate({ // initialize the plugin
        rules: {
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 3
            }
        }
    });

});

