var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'Hello', 'coolMethod', [arg0]);
};

exports.toast = function (arg0, success, error) {
    var obj = {};
    obj.message = arg0;
    // obj.duration = duration;
    
    exec(success, error, 'Hello', 'show', [obj]);
};
