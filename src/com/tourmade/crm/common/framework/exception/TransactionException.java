package com.tourmade.crm.common.framework.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

import org.springframework.dao.DataAccessException;

import com.tourmade.crm.common.framework.util.ResourceProperties;

/**
 * �����쳣�� <code>TransactionException</code> �̳���
 * <code>DataAccessException</code> 
 * ���ܣ������쳣��Ϣ<br>
 * �÷�����ݴ����errorCode ��ѯ properties�ļ��ж�Ӧ�ļ�ֵ,���������Ϣ
 *
 * @author  Konser
 * @version 0.1, 12/23/08
 * @see     java.lang.Exception
 * @since   JDK1.0
 */
public class TransactionException extends DataAccessException {

	/** serial version uid */
	private static final long serialVersionUID = -5011645032778946356L;
	
	/** δ�ҵ���ӦerrorCode����Ϣ */
	private final static String UNKNOW_ERROR = "UNKNOW_ERROR";
	
	/** ��չ�û��쳣�����ļ� */
	private final static String EXT_EXCEPTION="exception.properties";
	
	/** δ�ҵ�������Ϣ */
	private final static String NOT_FOUND_ERRORCODE="not find by this error code for message";


	/** Ƕ�׵��쳣���� */
	private Throwable nestedThrowable = null;

	/** �쳣����,Ĭ��ΪUNKNOW_ERROR */
	private String errorCode = UNKNOW_ERROR;

	/** ������滻ֵ,�滻��properties �ļ��е�{0}...{n}��ֵ */
	protected String[] errorArgs = null;

	/** ������Ϣ  */
	private String errorMessage = null;

	/**
	 * ���������Դ�ļ�
	 */
	static private ResourceProperties resourceBundle = new ResourceProperties("com/hxzk/base/exception/exception.properties");

	/**
	 * ����û���չ���쳣properties�ļ���Ϣ�����쳣
	 */
	static {
		resourceBundle.addProperties(EXT_EXCEPTION);
	}
	
	/**
	 * �޲ι��캯��
	 */
	public TransactionException() {
		super(null);
	}

    /**
     * ���ع���
     * @param errorCode 
     * 		  �������
     * @param errorArgs 
     *        ������Ϣ�滻,���ΰ��±��滻{0}...{n}����Ϣ
     */
    public TransactionException(String errorCode, String[] errorArgs) {
    	super(errorCode);
    	this.errorCode = errorCode;
        this.errorArgs = errorArgs;
    }

    /**
     * ���ع���
     * @param errorCode 
     * 		  �������
     * @param errorArg
     *        ������Ϣ�滻,�滻{0}����Ϣ
     */
    public TransactionException(String errorCode, String errorArg) {
    	super(errorCode);
    	this.errorCode = errorCode;
        this.errorArgs = new String[]{errorArg};
    }

    /**
     * ���ع���
     * @param errorCode
     * 		  �������
     * @param errorArgs
     *        ������Ϣ�滻,���ΰ��±��滻{0}...{n}����Ϣ
     * @param cause
     *        Ƕ�׵��쳣����
     */
    public TransactionException(String errorCode, String[] errorArgs, Throwable cause) {
        super(errorCode,cause);
        nestedThrowable=cause;
        this.errorCode = errorCode;
        this.errorArgs = errorArgs;
    }

    /**
     * ���ع���
     * @param errorCode
     *        �������
     * @param errorArg
     * 		  ������Ϣ�滻,�滻{0}����Ϣ
     * @param cause
     * 	      Ƕ�׵��쳣����
     */
    public TransactionException(String errorCode, String errorArg, Throwable cause) {
        super(errorCode,cause);
        nestedThrowable=cause;
        this.errorCode = errorCode;
        this.errorArgs = new String[]{errorArg};
    }
	
	
	/**
	 * ���ع���
	 * @param message ������Ϣ���ߴ������,�Ȱ����������в���,���δ�ҵ��򷵻�ԭ�ַ�
	 */
	public TransactionException(String message) {
		super(message);
		String errorMsg=getString(message);
		if(NOT_FOUND_ERRORCODE.equals(errorMsg)){
			errorMessage=message;
		}else{
			errorMessage=errorMsg;
		}
	}

	/**
	 * ���ع���
	 * @param cause Ƕ�׵��쳣����
	 */
	public TransactionException(Throwable cause) {
		super(null,cause);
		nestedThrowable=cause;
	}

	/**
	 * ���ع���
	 * @param message
	 * 	      ������Ϣ���ߴ������,�Ȱ����������в���,���δ�ҵ��򷵻�ԭ�ַ�
	 * @param cause
	 *        Ƕ�׵��쳣����
	 */
	public TransactionException(String message, Throwable cause) {
		super(message, cause);
		nestedThrowable=cause;
		String errorMsg=getString(message);
		if(NOT_FOUND_ERRORCODE.equals(errorMsg)){
			errorMessage=message;
		}else{
			errorMessage=errorMsg;
		}
	}

	/**
	 * ��ݴ�������ȡδ����ʽ������Ϣ, ���δ��ȡ���򷵻�NOT_FOUND_ERRORCODE
	 * 
	 * @param errorCode
	 *        �������
	 */
	private static String getString(String errorCode) {
		String message = "";
		message = resourceBundle.getProperty(errorCode);
		if (null == message || "".equals(message))
			message = NOT_FOUND_ERRORCODE;
		return message;
	}
	
	/**
     * ��ȡ����Ĵ�����Ϣ
     *
     * @return  ������Ϣ
     */
	public String getMessage() {
		String message = null;
		if (nestedThrowable != null) {
			message = nestedThrowable.getMessage();
		}
		if (errorMessage != null ) {
			if(message != null){
				return "nested throwable:"+message+",this:"+errorMessage;
			}else{
				return errorMessage;
			}
		}
		if(message != null){
			message = "nested throwable:"+message+",this:"+getString(errorCode);
		}else{
			message = getString(errorCode);
		}
		if (errorArgs != null)
			message = resourceBundle.format(message, (Object[]) errorArgs);

		return message;
	}
	/**
	 * ����쳣��Ϣ
	 * 
	 * @see java.lang.Throwable#printStackTrace()
	 */
	public void printStackTrace() {
		super.printStackTrace();
		if (nestedThrowable != null) {
			nestedThrowable.printStackTrace();
		}
	}

	/**
     * ��PrintStream����쳣��Ϣ
     *
     * @param printStream <code>PrintStream</code> to use for output
     */
	public void printStackTrace(PrintStream printStream) {
		super.printStackTrace(printStream);
		if (nestedThrowable != null) {
			nestedThrowable.printStackTrace(printStream);
		}
	}

    /**
     * ��PrintWriter����쳣��Ϣ
     *
     * @param printWriter <code>PrintWriter</code> to use for output
     */
	public void printStackTrace(PrintWriter printWriter) {
		super.printStackTrace(printWriter);
		if (nestedThrowable != null) {
			nestedThrowable.printStackTrace(printWriter);
		}
	}
	

	public static void main(String[] args){
		/*
		 * ��������,�Ȱ� this message .����һ����ֵ�������properties�ļ���û�������ֵ�򷵻�ԭ�� ��this message .��
		 */
		try {
			throw new TransactionException(" this message .");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// �����쳣��������Ƕ���쳣��
		try {
			throw new TransactionException("one two three",new Throwable(" object "));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		// ����쳣��Ų����쳣��Ϣ,���δ�ҵ�������������Ϣ
		try {
			throw new TransactionException("101");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// ����쳣��Ų����쳣��Ϣ,�滻�쳣��Ϣ�Ĳ���{0}...{n}��ռλ��
		try {
			throw new TransactionException("101","file");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	
		// ����쳣��Ų����쳣��Ϣ,�滻�쳣��Ϣ�Ĳ���{0}...{n}��ռλ��,׷��Ƕ�׵��쳣
		try {
			throw new TransactionException("101","file",new Throwable("super error."));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// ��ݱ�Ų����쳣���δ�鵽�򷵻�104����
		try {
			throw new TransactionException("104");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		try {
			throw new TransactionException("101","file");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// Ƕ���쳣
		try {
			throw new TransactionException("101",new Throwable(" super throw "));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// ���쳣����
		try {
			Throwable throwable=null;
			throw new TransactionException(throwable);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		// Ƕ�׵Ŀ��쳣����
		try {
			Throwable throwable=null;
			throw new TransactionException("101",throwable);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// ��ݼ�ֵ�����쳣��Ϣ�滻�쳣��Ϣ�еı�־λ{0}{1}
		try {
			throw new TransactionException("102",new String[]{"loginName","loginPassword"});
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
