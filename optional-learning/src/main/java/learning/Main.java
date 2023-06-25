package learning;

import java.util.Optional;
import java.util.function.Function;

public class Main {

	public static void main(String[] args) {

		// Kiểm tra null
		Optional<Object> empty = Optional.empty();
		System.out.println(empty.isPresent());
		System.out.println(empty.isEmpty());
		System.out.println("---------------------------");

		Optional<String> emptyV2 = Optional.of("Hello");
		System.out.println(emptyV2.isPresent());
		System.out.println(emptyV2.isEmpty());
		System.out.println("---------------------------");

		// Khi khai báo of mà không biết giữ liệu có hay không nếu null
		// thì nó sẽ lỗi NullPointerException
//		Optional<String> emptyV3 = Optional.of(null);
//		String orElse = emptyV3.orElse("word");
//		System.out.println(orElse);
		System.out.println("---------------------------");
		// Nếu không biết giữ liệu đầu vào là null hay không thì sử dụng ofNullable
		Optional<String> emptyV3 = Optional.ofNullable(null);
		System.out.println(emptyV3.isPresent());
		System.out.println(emptyV3.isEmpty());
		String orElse = emptyV3.orElse("word");
		System.out.println(orElse);
		System.out.println("---------------------------");

		// Tương đương
		String hello = null;
		String word = "word";
		if (hello == null) {
			System.out.println(word);
		} else {
			System.out.println(hello);
		}

		System.out.println("---------------------------");

		Optional<String> helloV1 = Optional.ofNullable("Hello");
		String orElseV1 = helloV1.map(String::toUpperCase).orElse("word");
		System.out.println(orElseV1);

		Optional<String> helloV2 = Optional.ofNullable(null);
		helloV2.ifPresent(System.out::printf);

		// ifPresent có dữ liệu đầu và sẽ sout còn ngược lại thì không hiện gì
		Optional<String> helloV3 = Optional.ofNullable("Hello");
		helloV3.ifPresent(System.out::printf);
		
		// ifPresentOrElse cũng giống ifPresent nhưng khi không có value vào thì nó sẽ xuất dữ liệu phía sau
		Optional<String> helloV4 = Optional.ofNullable(null);
		helloV4.ifPresentOrElse(System.out::printf, () -> {System.out.println("word");});
	}

}
