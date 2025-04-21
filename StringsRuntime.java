public class StringsRuntime{

	public static void string(){
		String temp = "";
		long start = System.nanoTime();
		for(int i=0; i<1000; i++){
			temp = temp + "a";
		}
		long end = System.nanoTime();
		System.out.println("String Concatenation time: "+((end-start)/1000000.0)+" ms");
	}
	
	public static void stringbuilder(){
		StringBuilder sb = new StringBuilder();
		long start = System.nanoTime();
		for(int i=0; i<1000; i++){
			sb.append("a");
		}
		long end = System.nanoTime();
		System.out.println("String Builder time: "+((end-start)/1000000.0)+" ms");
	}
	
	public static void stringbuffer(){
		StringBuffer sb = new StringBuffer();
		long start = System.nanoTime();
		for(int i=0; i<1000; i++){
			sb.append("a");
		}
		long end = System.nanoTime();
		System.out.println("String Buffer time: "+((end-start)/1000000.0)+" ms");
	}

	public static void main(String[] a){
		string();
		stringbuilder();
		stringbuffer();
	}
}