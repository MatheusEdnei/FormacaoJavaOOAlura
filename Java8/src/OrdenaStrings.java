import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import static java.util.Comparator.*;


public class OrdenaStrings {
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
//		Comparator<String> comparador = new ComparadorDeStringsPorTamanho();
//		palavras.sort(comparador);
//		
//		
//		Consumer<String> consumidor = new ConsumidorDeString();
//		palavras.forEach(consumidor);
		
//		UnaryOperator<String> operator = new MyOperator();
//		
//		palavras.replaceAll(operator);
		
//		palavras.forEach(new Consumer<String>() {
//			@Override
//			public void accept(String s) {
//				System.out.println(s);
//				
//			}
//		});
		
//		palavras.sort((s1, s2) -> {
//			if (s1.length() < s2.length())
//				return -1;
//			if (s1.length() > s2.length())
//				return 1;
//			return 0;
//		});
		
		palavras.forEach(s -> System.out.println(s));
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		
		palavras.sort((s1, s2) -> s1.length() - s2.length());
		
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		palavras.sort(Comparator.comparing(String::length));
		
		palavras.sort(comparing(String::length));
		
		palavras.sort(String.CASE_INSENSITIVE_ORDER);
		
		palavras.forEach(System.out::println);
		
		// Threads
		new Thread(() -> System.out.println("Executando um Runnable")).start();
	}
}

class ComparadorDeStringsPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}

}

class ConsumidorDeString implements Consumer<String> {

	@Override
	public void accept(String s) {
		System.out.println(s);

	}

}

class MyOperator implements UnaryOperator<String> {

	@Override
	public String apply(String s) {
		return s.toUpperCase();
	}

}
