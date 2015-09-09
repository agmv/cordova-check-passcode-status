

使用方法

```javascript
cordova.plugins.checkPasscode.checkPasscode(function( _status ){
    var PassCodeStatus;
    switch (_status){
        case "true":
            PassCodeStatus = true;
            break
        case "false":
            PassCodeStatus = false;
            break;
        default :
            PassCodeStatus = false;
            break
    }
    alert( "passcode status => " + PassCodeStatus )
}）
```
返回的值为

true [string]  已开启passcode
false [string]  关闭了 passcode
Unknown [string]  无法检测是否开启了 passcode

java source code
https://gist.github.com/doridori/54c32c66ef4f4e34300f

ios source code
https://github.com/liamnichols/UIDevice-PasscodeStatus
