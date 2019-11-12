var exec = require('cordova/exec');

function Hello() {}    //empty constructor

Hello.prototype.show = function (message, duration, successCallback, errorCallback){
    // create anonym object to send to native
    var obj = {};
    obj.message = message;
    obj.duration = duration;
    cordova.exec(successCallback, errorCallback, 'Hello', 'show', [obj]);
}

Hello.install = function() {
    if (!window.plugins) {
        window.plugins = {};
    }
    window.plugins.hello = new Hello();
    return window.plugins.hello;
}
cordova.addConstructor(Hello.install);

/*
exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'Hello', 'coolMethod', [arg0]);
};

exports.toast = function (arg0, success, error) {
    var obj = {};
    obj.message = arg0;
    // obj.duration = duration;
    
    exec(success, error, 'Hello', 'show', [obj]);
};
*/
