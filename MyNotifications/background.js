// Copyright (c) 2011 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

/*
  Displays a notification with the current time. Requires "notifications"
  permission in the manifest file (or calling
  "webkitNotifications.requestPermission" beforehand).
*/
function show() {
   RestfulResource();
   var notification = window.webkitNotifications.createNotification(
            'notification_new.png',                        // The image.
            'The Message:',                            // The title.
             localStorage.message                      // The body.
            );

  notification.show();
    
}

// Conditionally initialize the options.
if (!localStorage.isInitialized) {
  localStorage.isActivated = true;   // The display activation.
  localStorage.frequency = 1;        // The display frequency, in minutes.
  localStorage.isInitialized = true; // The option initialization.
  localStorage.isMessageRequired = true;
  localStorage.isCallsRequired = true;
  localStorage.message = ' ';
}

// Test for notification support.
if (window.webkitNotifications) {
  // While activated, show notifications at the display frequency.
  if (JSON.parse(localStorage.isActivated)) { show(); }

  var interval = 0; // The display interval, in minutes.

  setInterval(function() {
    interval++;

    if (
      JSON.parse(localStorage.isActivated) &&
        localStorage.frequency <= interval
    ) {
      show();
      interval = 0;
    }
  }, 60000);
}


function RestfulResource(){
    var responseString = '';
    var xmlhttp;
    var appEngineUrl = 
        'http://androidtochrome.appspot.com/resources/FetchCustomMessage/LastMessage';
    //var appEngineUrl = 'http://localhost:8888/resources/FetchCustomMessage/LastMessage';
    xmlhttp = new XMLHttpRequest();
    xmlhttp.open('GET',appEngineUrl,true);
    xmlhttp.send();
    xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4) {
        if ( xmlhttp.status == 200) {
            responseString = xmlhttp.responseText; 
            localStorage.message = responseString;
            //alert(responseString);
        }
        else
            alert("Error ->" + xmlhttp.responseText);
        localStorage.message = xmlhttp.responseText;
        }
    };


}