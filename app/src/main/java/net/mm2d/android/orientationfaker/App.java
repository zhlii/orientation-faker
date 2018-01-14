/*
 * Copyright (c) 2018 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package net.mm2d.android.orientationfaker;

import android.app.Application;

import net.mm2d.android.orientationfaker.settings.Settings;
import net.mm2d.log.AndroidLogInitializer;
import net.mm2d.log.Log;

/**
 * @author <a href="mailto:ryo@mm2d.net">大前良介 (OHMAE Ryosuke)</a>
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.setInitializer(AndroidLogInitializer.get());
        Log.initialize(BuildConfig.DEBUG, true);
        Settings.initialize(this);
    }
}
