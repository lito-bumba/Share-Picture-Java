package com.hackerrank.android;

import androidx.core.content.FileProvider;

public class AppFileProvider extends FileProvider {
    public static final String AUTHORITY = "com.hackerrank.android.fileProvider";
    public static final String FILE_NAME = "share_image.png";
    public static final String MIME_TYPE = "image/png";
}
