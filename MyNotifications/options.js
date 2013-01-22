// Copyright (c) 2011 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

/*
  Grays out or [whatever the opposite of graying out is called] the option
  field.
*/
function ghost(isDeactivated) {
  options.style.color = isDeactivated ? 'graytext' : 'black';
                                              // The label color.
  options.frequency.disabled = isDeactivated; // The control manipulability.
    //options.isMessageRequired = isDeactivated;
    //options.isCallsRequired = isDeactivated;
}

window.addEventListener('load', function() {
  // Initialize the option controls.
  options.isActivated.checked = JSON.parse(localStorage.isActivated);
                                         // The display activation.
  options.frequency.value = localStorage.frequency;
                                         // The display frequency, in minutes.
                        
  options.isMessageRequired.checked = JSON.parse(localStorage.isMessageRequired);                       
  options.isCallsRequired.checked = JSON.parse(localStorage.isCallsRequired);

  if (!options.isActivated.checked) { ghost(true); }
  //if (!options.isMessageRequired.checked) { ghost(true);}
  //if (!options.isCallsRequired.checked) {ghost(true);}

  // Set the display activation and frequency.
  options.isActivated.onchange = function() {
    localStorage.isActivated = options.isActivated.checked;
    //localStorage.isMessageRequired = options.isMessageRequired.checked;
    //localStorage.isCallsRequired = options.isCallsRequired.checked;
                        
    ghost(!options.isActivated.checked);
  };

  options.frequency.onchange = function() {
    localStorage.frequency = options.frequency.value;
  };
                        
  options.isMessageRequired.onchange = function() {
    localStorage.isMessageRequired = options.isMessageRequired.checked;
  };
                        
  options.isCallsRequired.onchange = function() {
    localStorage.isCallsRequired = options.isCallsRequired.checked;
  };
});
