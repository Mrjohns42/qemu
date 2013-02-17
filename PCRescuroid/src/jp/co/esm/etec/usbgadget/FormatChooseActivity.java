package jp.co.esm.etec.usbgadget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * SD�J�[�h�̃}�E���g��ISO�t�@�C���̃}�E���g��I�������ʂł��B
 */
public class FormatChooseActivity extends Activity {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.format_choose);
	}
	
	/**
	 * SD�J�[�h���}�E���g����{@link Activity}���N�����܂��B
	 * @param view SD�J�[�h�{�^��
	 */
	public void chooseSD(View view) {
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), SDCardMounter.class);
		startActivity(intent);
	}

	/**
	 * ISO�t�@�C�����}�E���g����{@link Activity}���N�����܂��B
	 * @param view ISO�t�@�C���{�^��
	 */
	public void chooseISO(View view) {
		Intent intent = new Intent();
		intent.setClass(getApplicationContext(), ISOFileMounter.class);
		startActivity(intent);
	}
}
