import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 @author Asma Bawazeer
 MSc Computer Science
 CSC 551
*/
public class RegularExpression {

	
	public static void main(String args[]) {

		String file1 = "/Volumes/bawazir/dataset/data_hw1_Q1,2,3,5.txt";
		
		String file2 = "/Volumes/bawazir/dataset/data_hw1_Q4.txt";
		
		String file3 = "/Volumes/bawazir/dataset/data_hw1_Q6.txt";
		String file4 = "/Volumes/bawazir/dataset/data_hw1_Q7.txt";

		String dataset1 = null;
		String dataset2 = null;
		String dataset3 = null;
		String dataset4 = null;

		try {
			FileReader fileReader1 = new FileReader(file1);
			FileReader fileReader2 = new FileReader(file2);
			FileReader fileReader3 = new FileReader(file3);
			FileReader fileReader4 = new FileReader(file4);

			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
			BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
			BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
			BufferedReader bufferedReader4 = new BufferedReader(fileReader4);

			dataset1 = bufferedReader1.readLine();
			dataset2 = bufferedReader2.readLine();
			dataset3 = bufferedReader3.readLine();
			dataset4 = bufferedReader4.readLine();

			System.out.println("1. Words with two consonants next to each other:");
			question1(dataset1);

			System.out.println("\n2. Words of length 5 or more that starts and ends with a vowel:");
			question2(dataset1);

			System.out.println("\n3. Words of length 7 or more that starts with a consonant and ends with a vowel:");
			question3(dataset1);

			System.out.println("\n4. All dates of form: dd-mm-yyyy:");
			question4(dataset2);

			System.out.println("\n5. All words that have the same letter repeated (next to each other):");
			question5(dataset1);

			System.out.println("\n6. The text after the abbreviation of 2-3 words that all start with a capital letter:");
			question6(dataset3);

			System.out.println("\n7. All the words in a given a string written in camel case:");
			question7(dataset4);

			bufferedReader1.close();
			bufferedReader2.close();
			bufferedReader3.close();
			bufferedReader4.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file");
		} catch (IOException ex) {
			System.out.println("Error reading file");
		}
	}

	public static void question1(String str) {
		Pattern pattern = Pattern.compile("[a-z&&[^aeiuo]]{2}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		String[] arrayStr = str.split(" ");
		String[] arrayMatch = new String[40];
		int l = 0;
		while (matcher.find()) {
			if (matcher.group().length() != 0)
				arrayMatch[l] = matcher.group().trim();
			l++;
		}
		for (int i = 0; i < arrayStr.length; i++) {
			for (int j = 0; j < arrayMatch.length; j++) {
				if (arrayMatch[j] != null)
					if (arrayStr[i].contains(arrayMatch[j])) {
						arrayStr[i] = arrayStr[i].replace(".", "");
						arrayStr[i] = arrayStr[i].replace(",", "");
						System.out.print(arrayStr[i]);
						System.out.println(" : (" + arrayMatch[j] + ")");
						break;
					}
			}
		}
	}

	public static void question2(String str) {
		Pattern pattern = Pattern.compile("\\b[aeiou]\\w{3,}[aeiou]\\b", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			if (matcher.group().length() != 0)
				System.out.println(matcher.group().trim());
		}
	}

	public static void question3(String str) {
		Pattern pattern = Pattern.compile("\\b[a-z&&[^aeiuo]]\\w{5,}[aeiou]\\b", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			if (matcher.group().length() != 0)
				System.out.println(matcher.group().trim());
		}
	}

	public static void question4(String str) {
		Pattern pattern = Pattern.compile("([0-9]{2})-(([0][1-9])||[10-12]||[1-9])-([0-9]{4})");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			if (matcher.group().length() != 0)
				System.out.println(matcher.group().trim());
		}
	}

	public static void question5(String str) {
		Pattern pattern = Pattern.compile("(\\w)\\1+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		String[] arrayStr = str.split(" ");
		String[] arrayMatch = new String[40];
		int l = 0;
		while (matcher.find()) {
			if (matcher.group().length() != 0)
				arrayMatch[l] = matcher.group().trim();
			l++;
		}
		for (int i = 0; i < arrayStr.length; i++) {
			for (int j = 0; j < arrayMatch.length; j++) {
				if (arrayMatch[j] != null)
					if (arrayStr[i].contains(arrayMatch[j])) {
						arrayStr[i] = arrayStr[i].replace(".", "");
						arrayStr[i] = arrayStr[i].replace(",", "");
						System.out.print(arrayStr[i]);
						System.out.println(" : (" + arrayMatch[j] + ")");
						break;
					}
			}
		}
	}

	public static void question6(String str) {

		Pattern pattern = Pattern.compile("\\b([A-Z][a-z]+\\s){2,3}+");
		Matcher matcher = pattern.matcher(str);
		String[] afterAbbr = new String[14];
		String beforeAbbr = "";
		char abbrev;
		int abbrPosition = 0;

		for (abbrPosition = 0; abbrPosition < afterAbbr.length; abbrPosition++)
			afterAbbr[abbrPosition] = "";
		abbrPosition = 0;

		while (matcher.find()) {
			if (matcher.group().length() != 0)
				
				beforeAbbr = matcher.group().trim();

			String[] splited = beforeAbbr.split(" ");

			for (int i = 0; i < splited.length; i++) {

				abbrev = splited[i].charAt(0);
				afterAbbr[abbrPosition] += Character.toString(abbrev);
			}
			if (str.contains(beforeAbbr))
				str = str.replaceAll(beforeAbbr, afterAbbr[abbrPosition]);
			abbrPosition++;
		}
		System.out.println(str);
	}
	public static void question7(String str) {
		Pattern pattern = Pattern.compile("(\\S+[A-Z][a-z]+)+");
		Pattern pattern2 = Pattern.compile("([A-Z][a-z]+)");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			if (matcher.group().length() != 0)
			{
				String str2=matcher.group().trim();
				Matcher matcher2 = pattern2.matcher(str2);
				System.out.print("\n"+str2);
				System.out.print(" -> ");
				while (matcher2.find()) {
					if (matcher2.group().length() != 0)
						System.out.print(" "+matcher2.group().trim());
				}
			}	
		}
	}
}