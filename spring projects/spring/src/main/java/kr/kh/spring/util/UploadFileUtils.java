package kr.kh.spring.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

	/***
	 * ������ uploadPath�� ������ �� ������ ���ϰ�ο� �̸��� ���ļ� ���ڿ��� ��ȯ�ϴ� �޼���
	 * ������ ���ε��� ��¥�� ���缭 ��/��/�� ������ �����ǰ� �� �ȿ� ���ε�
	 * @param uploadPath
	 * @param originalFileName
	 * @param fileData
	 * @return
	 * @throws IOException 
	 */
	public static String uploadFile(String uploadPath, String originalFileName, byte[] fileData) throws IOException {
		
		//���� ���ϸ��� ������ ������ ���ε��� �� ����Ⱑ ���� �ʰ� ó��
		UUID uuid = UUID.randomUUID();//��������ĺ��ڶ�� �θ� 
		String savedFileName = uuid.toString() + "_" + originalFileName; // 8-4-4-4-12(_���ϸ�)
		
		//�� ������ ������ ������ �ʰ� ��¥���� ���ε� ������ ����
		// 2023/09/01
		String savedPath = calcPath(uploadPath);// ���ε� ��¥�� �������� ��/��/�� ������ ������ �����ϰ� ������ ��θ� ��ȯ
		
		//������ ����
		File target = new File(uploadPath + savedPath, savedFileName);
		FileCopyUtils.copy(fileData, target);
		
		return uploadFileName(uploadPath,savedPath ,savedFileName);
	}

	private static String uploadFileName(String uploadPath, String savedPath, String savedFileName) {
		String fileName = savedPath + File.separator + savedFileName;
		return fileName.replace(File.separator, "/");//������ ���ڿ��̱� ������ "/"�� ���ڿ�ó���� ���־����
	}

	/***
	 * uploadPath�� ���� ��¥�� �´� ��/��/�� ������ ������ �����ϰ�, ������ ��θ� ��ȯ�ϴ� �޼���
	 * @param uploadPath ��/��/�� ������ ���� �θ� ����
	 * @return ���� ��¥�� ��/��/�� ���� ���
	 */
	private static String calcPath(String uploadPath) {
		Calendar cal = Calendar.getInstance();
		// \\2023
		String yearPath = File.separator + cal.get(Calendar.YEAR);//separator �ü���� ���缭 �������ִ� �Լ�
		// \\2023\09
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		//deciamlformat �� ����ִ� �ڸ��� ä���ִ°� �� ��� 03����ó�� 0�� ����ִ°��
		
		// \\ 2023\\09\\01
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		//������ ����
		makeDir(uploadPath, yearPath, monthPath, datePath);
				return datePath;
	}

	private static void makeDir(String uploadPath, String... paths ) {
		// datePath�� �̹� �����ϸ� �̹� ������ �ִ� ����̹Ƿ� ������ �� ���� �ʿ䰡 ����
		if(new File(uploadPath + paths[paths.length -1]).exists()) {
		 return;	
		}
		for(String path : paths) {
			File dir = new File(uploadPath + path);
			if(!dir.exists()) {
				dir.mkdir(); // mkdir�� ������ ����� �޼ҵ�
			}
		}
	}
}
