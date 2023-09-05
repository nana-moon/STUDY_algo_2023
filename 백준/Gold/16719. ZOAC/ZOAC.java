import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String[] arr = new String[origin.length()];
		int len = origin.length();

		String maxStr = "";
		for(int i = 0; i < len+1; i++) {
			maxStr += "Z";
		}
		arr[len-1] = origin;

		while (len > 1) {
			int maxIdx = 0;
			for (int i = 0; i < len; i++) {
				String nStr = origin.substring(0,i) + origin.substring(i+1,len);
				if (maxStr.compareTo(nStr) > 0) {
					maxStr = nStr;
					maxIdx = i;
				}
			}

			origin = maxStr;
			len -=1;
			arr[len-1] = origin;
		}
		// System.out.println(Arrays.toString(arr));
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}
