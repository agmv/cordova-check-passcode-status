/********* checkPasscode.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>
#import "UIDevice+PasscodeStatus.h"

@interface checkPasscode : CDVPlugin {
  // Member variables go here.
}

- (void)checkPasscodeStatus:(CDVInvokedUrlCommand*)command;
@end

@implementation checkPasscode

- (void)checkPasscodeStatus:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo;

    LNPasscodeStatus status = [UIDevice currentDevice].passcodeStatus;
    switch (status) {
        case LNPasscodeStatusEnabled:
            echo = @"true";
            break;
            
        case LNPasscodeStatusDisabled:
            echo = @"false";
            break;
            
        case LNPasscodeStatusUnknown:
        default:
            echo = @"Unkonwn";
            break;
    }

    pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:echo];

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
