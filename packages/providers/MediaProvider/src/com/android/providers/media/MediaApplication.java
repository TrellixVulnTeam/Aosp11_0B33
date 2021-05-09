/*
 * Copyright (C) 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.providers.media;

import android.app.Application;
import android.content.Context;

import com.android.providers.media.util.Logging;

import java.io.File;

public class MediaApplication extends Application {
    static {
        System.loadLibrary("fuse_jni");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        final File persistentDir = this.getDir("logs", Context.MODE_PRIVATE);
        Logging.initPersistent(persistentDir);
    }
}