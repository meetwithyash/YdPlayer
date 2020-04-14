package com.ykhokhaneshiya.dcdhameliya.ydplayer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import android.view.TextureView;

public abstract class YdMediaInterface implements TextureView.SurfaceTextureListener {

    static SurfaceTexture SAVED_SURFACE;
    HandlerThread mMediaHandlerThread;
    Handler mMediaHandler;
    Handler handler;
    public Ydvd ydvd;


    public YdMediaInterface(Ydvd ydvd) {
        this.ydvd = ydvd;
    }

    public abstract void start();

    public abstract void prepare();

    public abstract void pause();

    public abstract boolean isPlaying();

    public abstract void seekTo(long time);

    public abstract void release();

    public abstract long getCurrentPosition();

    public abstract long getDuration();

    public abstract void setVolume(float leftVolume, float rightVolume);

    public abstract void setSpeed(float speed);

    public abstract void setSurface(Surface surface);
}
