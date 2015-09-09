var exec = require('cordova/exec');

exports.checkPasscode = function(success, error) {
    exec(success, error, "checkPasscode", "checkPasscodeStatus", []);
};