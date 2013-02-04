package jp.co.esm.etec.usbgadget;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;

/**
 * {@link MountService}�̃��[�e�B���e�B�N���X�ł��B
 */
public class MountServiceUtil {
	
	/**
	 * {@link MountService}���擾���܂��B
	 * 
	 * @param context �R���e�L�X�g
	 * @return {@link MountService}
	 */
	public static MountService getMountService(Context context) {
		//Object mountService = context.getSystemService("mount");
		Object mountService = _getMountService(context);
		MountServiceInvocationHandler handler = new MountServiceInvocationHandler(mountService);
		return (MountService)Proxy.newProxyInstance(context.getClassLoader(), new Class[]{MountService.class}, handler);
	}
	
	private static Object _getMountService(Context context) {
		Class<?> cls;
		try {
			cls = Class.forName("android.os.ServiceManager");
			Method method = cls.getMethod("getService", new Class[]{String.class});
			Object binder = method.invoke(cls, "mount");
			Class<?> imountserviceStubCls = Class.forName("android.os.IMountService$Stub");
			Method asInterface = imountserviceStubCls.getMethod("asInterface", new Class[]{IBinder.class});
			return asInterface.invoke(imountserviceStubCls, binder);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * {@link MountService}�̃��\�b�h�Ăяo���ɉ�����com.android.server.MountService�̃��\�b�h���Ăяo��{@link InvocationHandler}�ł��B
	 * ISO�t�@�C���̃}�E���g�@�\�̓J�X�^�}�C�Y���ꂽcom.android.server.MountService���񋟂��܂���
	 * com.android.server.MountService�͔���JAPI�ł��邽�߁A���ڂ��̃��\�b�h���Ăяo�����Ƃ��ł��܂���B
	 * ���̂��߁A ISO�t�@�C���̃}�E���g����ɕK�v�ȃ��\�b�h���`����{@link MountService}�z����com.android.server.MountService�̃��\�b�h���Ăяo�����Ƃ�
	 * �K�v�ȋ@�\��񋟂��܂��B
	 */
	private static class MountServiceInvocationHandler implements InvocationHandler {
		/**
		 * com.android.server.MountService�C���X�^���X
		 */
		private Object mountService;
		
		/**
		 * ������]������com.android.server.MountService�C���X�^���X���w�肵��{@link MountServiceInvocationHandler}���쐬���܂��B
		 * 
		 * @param mountService com.android.server.MountService�C���X�^���X
		 */
		public MountServiceInvocationHandler(Object mountService) {
			this.mountService = mountService;
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			try {
				//
//				Method[] methods = mountService.getClass().getMethods();
//				for (Method m : methods) {
//					Log.d("MountServiceUtil", m.getName());
//				}
				Method serviceMethod = mountService.getClass().getMethod(method.getName(), method.getParameterTypes());
				return serviceMethod.invoke(mountService, args);
			} catch (NoSuchMethodException e) {
				throw new UnsupportedOperationException(mountService.getClass().getName() + "." + method.getName() + "() method is not found.", e);
			}
		}
	}
}
