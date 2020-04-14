# YdPlayer (Android)

<b>YdPlayer</b> is a android library to help embed video player in your Android Application.

Example:

<table>
  <tr>
    <td>
    <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/1.jpg"/>
    </td>
    <td>
    <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/2.jpg" />
    </td>
    <td>
    <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/3.jpg" />
    </td>
  </tr>
   <tr>
    <td>
    <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/4.jpg"/>
    </td>
    <td>
    <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/5.jpg"/>
    </td>
    <td>
    <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/6.jpg"/>
    </td>
  </tr>
     <tr>
      <td>
      <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/7.jpg"/>
      </td>
      <td>
      <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/8.jpg"/>
      </td>
      <td>
      <img src="https://raw.githubusercontent.com/dcdhameliya/YdPlayer/master/SS/9.jpg"/>
      </td>
    </tr>
</table>

It can be used to display video inside your app with basic(Play/Pause Control) as well as advanced(Forward/Backward + Brightness + Volume Controls) controls.

## Download
Add belowed code in your root ```build.gradle``` at the end of repositories:
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

Now add below code to your app ```build.gradle```:
```groovy
android {
    ...
    compileOptions {
        targetCompatibility 1.8
    }
}
dependencies {
    ...
    implementation 'com.github.ykhokhaneshiya:YdPlayer:0.0.1'
}
```

## Usage
Add below code to ```AndroidManifest.xml``` file

```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
<!-- Add this internet permission to play video from server or any other url/link  -->
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<!-- Add this read storage permission to play video from mobile device  -->

<application
    ...
    android:usesCleartextTraffic="true"
    ...>
    <activity
        ...
        android:configChanges="orientation|screenSize|keyboardHidden"
        android:screenOrientation="fullSensor"
        android:theme="@style/AppTheme"
        ...>
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <action android:name="android.intent.action.VIEW" />

            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
    </activity>
</application>
```

Now change ```styles.xml``` for full screen video:
```xml
<style name="AppTheme" parent="@style/Theme.AppCompat.Light.NoActionBar">
    <item name="android:windowNoTitle">true</item>
    <item name="android:windowActionBar">false</item>
    <item name="android:windowFullscreen">true</item>
    <item name="android:windowContentOverlay">@null</item>
</style>
```

Add view to your ```layout.xml``` & bind as usual:
```xml
<com.ykhokhaneshiya.dcdhameliya.ydplayer.YdPlayer
        android:id="@+id/yd_video"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

```Actvity.java```
```java

    YdPlayer ydPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // for full scrren video plyer
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.layout);
        
        // initialization of ydPlayer
        ydPlayer = findViewById(R.id.yd_video);

        // this method is used to set a video in player you can also pass local path of a video, Last parameter is a video name
        ydPlayer.setUp(this, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "Local Video");

        // if you want to set thumbnail then set your thumbnail in ydPlayer.posterImageView 
        Glide.with(this).load("https://cdn.vox-cdn.com/thumbor/Pkmq1nm3skO0-j693JTMd7RL0Zk=/0x0:2012x1341/1200x800/filters:focal(0x0:2012x1341)/cdn.vox-cdn.com/uploads/chorus_image/image/47070706/google2.0.0.jpg").into(ydPlayer.posterImageView);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // to pause video, it is necessary
        ydPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // to start a video, it is not necessary
        ydPlayer.start();
    }
```

<br><br>You may found anoher YdPlayer library [here](https://github.com/dcdhameliya/YdPlayer).<br><br>

You can download demo project from this [link](https://app.box.com/s/gnj7a2cg8yjmwybe7qkmd2v2q2eaouus).<br>
The password of this DemoYdPlayer-ykhokhaneshiya.rar file is ```dcdhameliya```.

If you want to contribute something then write me on the email.
email：ykhokhaneshiya@gmail.com

&copy; Yash Khokhaneshiya
Licensed under the [MIT License](LICENSE).
