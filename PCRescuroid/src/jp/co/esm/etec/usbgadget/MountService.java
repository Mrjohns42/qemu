package jp.co.esm.etec.usbgadget;


/**
 * USB�X�g���[�W����ISO�t�@�C����USB�z�X�g�ɑ΂��ă}�E���g�E�A���}�E���g���s���T�[�r�X�̃C���^�t�F�[�X�ł��B
 */
public interface MountService {
	/**
	 * ISO�C���[�W�Ƃ��ă}�E���g���郂�[�h
	 */
	public static final String MODE_CD = "ums_mode_cd"; 
	/**
	 * SD�J�[�h�Ƃ��ă}�E���g���郂�[�h
	 */
	public static final String MODE_SD = "ums_mode_sd"; 
	/**
	 * �w��̃p�X��ISO�t�@�C�����}�E���g����Ă���ꍇ��{@code true}��Ԃ��܂��B
	 * 
	 * @param path ISO�t�@�C���̃p�X
	 * @return�@�}�E���g����Ă���ꍇ��{@code true}�A�}�E���g����Ă��Ȃ��ꍇ��{@code false}
	 * @throws UnsupportedOperationException �v���b�g�t�H�[����������T�|�[�g���Ȃ��ꍇ
	 */
	public boolean isISOFileMounted(String path);
	
	/**
	 * �w��̃p�X��ISO�t�@�C�����}�E���g���܂��B
	 * 
	 * @param path �}�E���g����ISO�t�@�C���̃p�X
	 * @throws UnsupportedOperationException �v���b�g�t�H�[����������T�|�[�g���Ȃ��ꍇ
	 */
	public void mountMedia(String path);

	/**
	 * �w��̃p�X��ISO�t�@�C�����A���}�E���g���܂��B
	 * 
	 * @param path �A���}�E���g����ISO�t�@�C���̃p�X
	 * @throws UnsupportedOperationException �v���b�g�t�H�[����������T�|�[�g���Ȃ��ꍇ
	 */
	public void unmountMedia(String path);
	
	
	public boolean getMassStorageConnected();

	 public boolean getMassStorageEnabled();
	
	 public void setMassStorageEnabled(boolean enable);

	/**
	 * �X�g���[�W�̃��[�h���擾���܂��B
	 * 
	 * @return {@link #MODE_CD}�܂���{@link #MODE_SD}
	 */
	public String getMassStorageMode();
	
	/**
	 * �X�g���[�W�̃��[�h��ݒ肵�܂��B
	 * 
	 * @param mode {@link #MODE_CD}�܂���{@link #MODE_SD}
	 */
	public void setMassStorageMode(String mode);
}
