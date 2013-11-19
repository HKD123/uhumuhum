package com.example.onebeef2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;

public class AbleCamera extends Activity {
	public static String IMAGE_FILE = "capture.jpg";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
		setContentView(R.layout.ablecamera);
		Toast.makeText(this, "카메라 인식", Toast.LENGTH_SHORT).show();
		final CameraSurfaceView cameraView = new CameraSurfaceView( getApplicationContext());
		FrameLayout previewFrame = (FrameLayout) findViewById(R.id.previewFrame);
		previewFrame.addView(cameraView);

		Button saveBtn = (Button) findViewById(R.id.saveBtn);
		saveBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				cameraView.capture(new Camera.PictureCallback() {

					@Override
					public void onPictureTaken(byte[] data, Camera camera) {
						// TODO Auto-generated method stub
						try {
							Bitmap bitmap = BitmapFactory.decodeByteArray(data,
									0, data.length);
							String outUriStr = MediaStore.Images.Media
									.insertImage(getContentResolver(), bitmap,
											"Captured Image",
											"Caputred Image using Camera.");
							if (outUriStr == null) {
								Log.d("SampleCapture", "Image insert failed.");
								return;
							} else {
								Uri outUri = Uri.parse(outUriStr);
								sendBroadcast(new Intent(
										Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
										outUri));
							}
							Toast.makeText(getApplicationContext(),
									"카메라로 찍은 사진을 앨범에 저장했습니다.",
									Toast.LENGTH_SHORT).show();
						} catch (Exception e) {
							Log.e("SampleCapture", "Failed to insert image.", e);
						}
					}
				});
			}
		});
	}

	public class CameraSurfaceView extends SurfaceView implements
			SurfaceHolder.Callback {
		private SurfaceHolder mHolder;
		private Camera camera = null;

		public CameraSurfaceView(Context context) {
			super(context);

			mHolder = getHolder();
			mHolder.addCallback(this);
			mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, 
				int height) {
			// TODO Auto-generated method stub
			camera.startPreview();
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			if (camera != null) {
				camera.stopPreview();
				camera.release();
				camera = null;
			}
			
			 /* CAMERA_FACING_FRONT가 전면카메라임, 후방카메라 사용하고 싶으면 CAMERA_FACING_BACK으로 변경 */
	        camera = Camera.open(CameraInfo.CAMERA_FACING_FRONT);
	        /* surface 사용시 카메라가 회전되어 있어 그에 대한 보정 */
	        camera.setDisplayOrientation(90);		
	        
			try {
				camera.setPreviewDisplay(mHolder);
			} catch (Exception e) {
				Log.e("CameraSurfaceView", "Failed to set camera preview.", e);
			}

		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			camera.stopPreview();
			camera.release();
			camera = null;
		}

		public boolean capture(Camera.PictureCallback handler) {
			if (camera != null) {
				camera.takePicture(null, null, handler);
				return true;
			} else {
				return false;
			}
		}
	}
}
