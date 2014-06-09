package com.furflez.sdsoundtracker;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Main extends Activity {
	MediaPlayer gunhido;
	Button buttonGunhido;

	Activity activity = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buttonGunhido = (Button) findViewById(R.id.button1);
		gunhido = MediaPlayer.create(activity, R.raw.gunhido);
		buttonGunhido.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,
				android.R.drawable.ic_media_play);


		buttonGunhido.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				if (gunhido.isPlaying()) {
					buttonGunhido.setCompoundDrawablesWithIntrinsicBounds(0, 0,
							0, android.R.drawable.ic_media_play);
					gunhido.stop();
					gunhido.reset();
					gunhido.release();
					gunhido = MediaPlayer.create(activity, R.raw.gunhido);
				} else {
					gunhido.start();
					buttonGunhido.setCompoundDrawablesWithIntrinsicBounds(0, 0,
							0, android.R.drawable.ic_media_pause);
				}

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class PlayVerification extends Thread {

		public void run() {

			while (gunhido.isPlaying()) {

			}

			buttonGunhido.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0,
					android.R.drawable.ic_media_play);

		}
	}
}
