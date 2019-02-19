/**
 * This class consists of methods to manipulate java.util.Date.
 *
 * @author  Florian Bourdoux
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverterTools {

	// Formats
	private final static String engFormatStr = "yyyy-MM-dd"; 			// english format string
	private final static String engDisplayFormatStr = "yyyy/MM/dd"; 	// english format for display string
	private final static String frFormatStr = "dd-MM-yyyy"; 			// french format string
	private final static String frDisplayFormatStr = "dd/MM/yyyy"; 		// french format for display string

	// Formatters
	private final static SimpleDateFormat engFormat = new SimpleDateFormat(engFormatStr); 				// english format
	private final static SimpleDateFormat engDisplayFormat = new SimpleDateFormat(engDisplayFormatStr); // english format for display
	private final static SimpleDateFormat frFormat = new SimpleDateFormat(frFormatStr); 				// french format
	private final static SimpleDateFormat frDisplayFormat = new SimpleDateFormat(frDisplayFormatStr); 	// french format for display

	// Values of duration units in milliseconds
	private final static long SECOND = 1000L;
	private final static long MINUTE = SECOND * 60;
	private final static long HOUR = MINUTE * 60;
	private final static long DAY = HOUR * 24;

	// Suppresses default constructor
	private DateConverterTools() {
	}
	
	/**
	 * This method converts a java.util.Date to a String. The format of the string
	 * returned will be {@value #engFormatStr}
	 *
	 * @param date the java.util.Date to be converted.
	 * @return the string of the date converted
	 */
	public static String DateToEngString(java.util.Date date) {
		return engFormat.format(date);
	}

	/**
	 * This method converts a java.util.Date to a String. The format of the string
	 * returned will be {@value #frFormatStr}
	 *
	 * @param date the java.util.Date to be converted.
	 * @return the string of the date converted
	 */
	public static String DateToFrString(java.util.Date date) {
		return frFormat.format(date);
	}

	/**
	 * This method converts a java.util.Date to a String. The format of the string
	 * returned will be {@value #engDisplayFormatStr}
	 *
	 * @param date the java.util.Date to be converted.
	 * @return the string of the date converted
	 */
	public static String DateToEngDisplayString(java.util.Date date) {
		return engDisplayFormat.format(date);
	}

	/**
	 * This method converts a java.util.Date to a String. The format of the string
	 * returned will be {@value #frDisplayFormatStr}
	 *
	 * @param date the java.util.Date to be converted.
	 * @return the string of the date converted
	 */
	public static String DateToFrDisplayString(java.util.Date date) {
		return frDisplayFormat.format(date);
	}

	/**
	 * This method converts a string to a Date.
	 *
	 * @param string to be converted in Date, must be of {@value #engFormatStr} format.
	 * @return the date converted from the string
	 * @throws ParseException if the string is not of the specified format
	 */
	public static java.util.Date engStringToDate(String string) throws ParseException {
		return engFormat.parse(string);
	}

	/**
	 * This method adds a duration of time to a date.
	 *
	 * @param date         starting date
	 * @param days         number of days to add to date
	 * @param hours        number of hours to add to date
	 * @param minutes      number of minutes to add to date
	 * @param seconds      number of seconds to add to date
	 * @param milliseconds number of milliseconds to add to date
	 * @return the date converted from the string
	 */
	public static java.util.Date addTime(java.util.Date date, int days, int hours, int minutes, int seconds,
			int milliseconds) {
		long buffer = date.getTime();
		buffer += milliseconds;
		buffer += seconds * SECOND;
		buffer += minutes * MINUTE;
		buffer += hours * HOUR;
		buffer += days * DAY;
		return new java.util.Date(buffer);
	}

	/**
	 * This method converts a java.util.Date to a sql.Timestamp. Used mainly to send
	 * a date while keeping time info to a datetime column in SQL data base.
	 *  Example : preparedStatement.setTimestamp(1,DateConverterTools.utilToSqlTimestamp(new java.util.Date())
	 *
	 * @param date date to be converted
	 * @return sql.Timestamp converted from the date, null if date is null
	 */
	static java.sql.Timestamp utilToSqlTimestamp(java.util.Date date) {
		return date == null ? null : new java.sql.Timestamp(date.getTime());
	}

	/**
	 * This method converts a sql.Timestamp to a java.util.Date. Used mainly to get
	 * a date from a datetime column in SQL data base.
	 * Example : date=DateConverterTools.sqlTimestampToUtil(resultSet.getTimestamp("column_name"))
	 *
	 * @param sqlDateTime sql.Timestamp to be converted
	 * @return java.util.Date converted from the sql.Timestamp, null if sqlDateTime
	 *         is null
	 */
	static java.util.Date sqlTimestampToUtil(java.sql.Timestamp sqlDateTime) {
		return sqlDateTime == null ? null : new java.util.Date(sqlDateTime.getTime());
	}

	/**
	 * This method converts a java.util.Date to a sql.Timestamp. Used mainly to send
	 * a date without keeping time info to a date column in SQL data base.
	 * Example : preparedStatement.setDate(1,DateConverterTools.utilToSqlDate(new java.util.Date())
	 *
	 * @param date date to be converted
	 * @return java.util.Date converted from the date, null if date is null
	 */
	static java.util.Date utilToSqlDate(java.util.Date date) {
		return date == null ? null : new java.sql.Date(date.getTime());
	}

	/**
	 * This method converts a java.sql.Date to a sjava.util.Date. Used mainly to get
	 * a date from a date column in SQL data base. 
	 * Example : date=DateConverterTools.sqlDateToUtil(resultSet.getDate("column_name"))
	 *
	 * @param sqlDate date to be converted
	 * @return java.util.Date converted from the sqlDate, null if date is null
	 */
	static java.util.Date sqlDateToUtil(java.sql.Date sqlDate) {
		return sqlDate == null ? null : new java.util.Date(sqlDate.getTime());
	}

}
