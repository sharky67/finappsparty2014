package com.itglas.constants;

public class Constants {
	public static final int TYPE_ATM = 0;
	public static final int TYPE_PROPIEDAD = 1;
	
	public static final String TYPE_ATM_STR = "ATM";
	public static final String TYPE_PROPIEDAD_STR = "PROPERTY";
	
	public static final String ID_CARD_SCROLL = "id_card_scroll";
	public static final String ID_CONTACT = "id_contact";
	public static final String ID_TYPE_SEND = "id_type_send";
	public static final String TYPE_TRANSFER = "transfer";
	public static final String TYPE_DIRECT = "direct";
	
	public static final int JORDI = 0;
	public static final int GERARD = 1;
	public static final int VICTOR = 2;
	
	public static final char ATM_FILE_SEPARATOR = '\t';
	public static final int MAX_NUMBER_ATMS_ON_SCREEN = 5; //Maximum number of ATMs on screen at once
	
	public static final int COIN_DIAMETER_NORMAL = 145; //in pixels
	public static final int COIN_DIAMETER_SMALL = 80;   //in pixels
	
	public static final int TYPE_COIN_SIZE_SMALL = 0;
	public static final int TYPE_COIN_SIZE_MEDIUM = 1;
	public static final int TYPE_COIN_SIZE_BIG = 2;
	public static final int TYPE_COIN_SIZE_HUGE = 3;
	
	public static final int ID_BALANCE_ACCOUNT = 0;
	public static final int ID_STATEMENTS_ACCOUNT = 1;
	public static final int ID_BALANCE_CREDIT_CARDS = 2;
	public static final int ID_STATEMENTS_CREDIT_CARDS = 3;
	public static final int ID_INSTANT_MONEY = 4;
	public static final int ID_ACCOUNT = 5;
	public static final int ID_CREDIT_CARD = 6;
	
	public static final int TOP_SIZE_SMALL_COIN = 183;
	
    /** 
     * The distance to accept a coin as near 
     */
    public static final int NEAR_ATM_RANGE = 2000; //in meters

    /**
     * The size of the farer coins
     */
    public static int FAR_COIN_INDICATOR_SIZE = 90;
    
    /**
     * The size of the nearer coins
     */
    public static int NEAR_COIN_INDICATOR_SIZE = 200;
	
	/**
	 * Logging tag
	 */
	public static final String LOG_TAG = "com.itglas.whatsappforglass";

	/**
	 * API timeout
	 */
	public static final int API_POLICY_TIMEOUT = 30;

	/**
	 * API retries
	 */
	public static final int API_POLICY_RETRIES = 1;
	
	/**
	 * API encoding
	 */
	public static final String ENCODING = "utf-8";
    
    /**
     * Contains the current SDK
     */
    public static final int CURRENT_SDK = android.os.Build.VERSION.SDK_INT;
    
	/**
	 * The delay to left until displaying the options menu 
	 */
	public static final int DELAY_UNTIL_DISPLAY_MENU = 1500;
	public static final int DELAY_SHOW_INFO_USER = 3000;
	
    public static final int SCREEN_WIDTH = 639;
    public static final int SCREEN_HEIGHT = 360;

	/**
	 * The radio of the corner of the rectangle
	 */
	public static final int BORDER_RADIO = 20;
	
	/**
	 * Constants to analyze the spoken text in currency conversion
	 */
	public static final String TOKEN_TO = " to ";
	public static final String TOKEN_IN = " in ";

	/**
	 * Dictionary file
	 */
	public static String DICTIONARY_FILE_NAME="dictionary_rates.xml";
	
    /** 
     * The rates file 
     */
	public static String CURRENCY_FILE_NAME="currency_rates.xml";
	public static String url = "http://www.ecb.europa.eu/stats/eurofxref/eurofxref-daily.xml";
	
	public static int GET_TEXT = 111;
	public static String ID_XMLFile = "xml_file";
	public static String ID_URL = "id_url";
	public static String ID_MSG = "id_msg";
	public static String ID_OK = "id_ok";
	public static String ID_ERROR = "id_error";
	public static String ID_NO_CAMERA = "id_no_camera";
	public static String ID_NEW = "id_new";
	public static String ID_URL_NEW = "id_url_new";
	public static String ID_OPERATION = "id_operation";
	public static String ID_AMOUNT = "id_amount";
	public static String ID_PHONE = "id_phone";
	
	public static String defaultEnconding = "UTF-8";
	public static int bufferSize = 1024;
	
	
	public static String MSG_OK = "Rates sucessfully updated!";
	public static String MSG_UPDATE_OK = "Rates sucessfully updated!";
	public static String MSG_ERROR_WRITING = "Error: writing xml file to glasses";
	public static String MSG_ERROR_TO_SAVE = "Error: to save downloaded xml file to glasses";
	public static String MSG_ERROR_FILE_EMPTY_NOT_FOUND = "Error: file not found or empty";
	
	public static int OK = 99;
	public static int ERROR_WRITING = 100;
	public static int ERROR_TO_SAVE = 101;
	public static float RATE_ERROR = -1.0f;
	
	public static String XML_TIME_LABEL = "<Cube time=\'";
	public static String XML_CURRENCY_LABEL = "<Cube currency=\'";
	public static String XML_RATE_LABEL = "rate=\'";
	public static String XML_END_LABEL = "\'/>";
	public static int CURRENCY_CODE_LENGTH = 3;
	public static String XML_DATE_FORMAT = "yyyy-MM-dd";
	public static int XML_DATE_LENGTH = 10;
	public static String EURO_CODE = "EUR";
	public static char CURRENCY_DECIMALS_SEPARATOR = '.';
	public static char CURRENCY_MILES_SEPARATOR = ',';
	
	public static char DOLLAR_SYMBOL = '$';
	public static String US_DOLLAR_CODE = "USD";

	//These next two constants are to show the conversion result on a card
	public static String CONVERTER_RESULT_PREFIX = "Rates were last updated on ";
	public static String CONVERTER_RESULT_DATE_FORMAT = "MMMM dd, yyyy";
	
	//Colors for the radar view
	public static int radar_view_atm_mark_color = 0xD9D919;
	public static int radar_view_avis_mark_color = 0xFF2400;
	public static int radar_view_europcar_mark_color = 0x6B8E23;
	public static int radar_view_sixt_mark_color = 0xFF7F00;
	
	//Extras for the detail ATM activity
	public static String EXTRA_ADDRESS = "extra_address";
	public static String EXTRA_PHONE = "extra_phone";
	public static String EXTRA_CODE = "extra_code";
	public static String EXTRA_TYPE = "extra_type";
	public static String EXTRA_LATITUDE = "extra_latitude";
	public static String EXTRA_LONGITUDE = "extra_longitude";
	
	public static String NOT_AVAILABLE = "N/A";
	public static String NOT_VALID_PHONE_1 = "E+"; //If the phone number contains then it is not valid
	public static String NOT_VALID_PHONE_2 = "-";  //If the phone number starts with '-' then it is not valid
}
