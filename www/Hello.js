var exec = require('cordova/exec');

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'Hello', 'coolMethod', [arg0]);
};

exports.toast = function (arg0, success, error) {
    exec(success, error, 'Hello', 'show', [arg0]);
};
