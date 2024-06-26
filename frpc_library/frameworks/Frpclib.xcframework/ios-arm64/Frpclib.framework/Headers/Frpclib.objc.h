// Objective-C API for talking to github.com/fatedier/frp/cmd/frpc Go package.
//   gobind -lang=objc github.com/fatedier/frp/cmd/frpc
//
// File is generated by gobind. Do not edit.

#ifndef __Frpclib_H__
#define __Frpclib_H__

@import Foundation;
#include "ref.h"
#include "Universe.objc.h"


FOUNDATION_EXPORT void FrpclibCheckVersion(void);

FOUNDATION_EXPORT NSString* _Nonnull FrpclibGetVersion(void);

FOUNDATION_EXPORT void FrpclibRun(NSString* _Nullable cfgFilePath);

#endif
