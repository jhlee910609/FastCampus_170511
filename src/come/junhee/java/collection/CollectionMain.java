package come.junhee.java.collection;

import java.util.ArrayList;
import java.util.HashMap;

import com.junhee.java.dummy.Bird;
import com.junhee.java.dummy.Student;

public class CollectionMain {

	public static void main(String[] args) {
		
		// 1. List 계열
	
			// 내부적으로 값이 입력되면 값과 함께 순서가 저장된다.
			// .add(값); : 값 입력
			// .get(순서 파라미터); : 값출력 
			// .size() : 리스트 내부의 값 개수.
		
		// 주로 현업에선 ArrayList arrayList(); = new ArrayList(); 만 사용함
		
		ArrayList<Student> list = new ArrayList<>();
		
		Student a1 = new Student();
		a1.name = "홍길동";
		a1.age = 500;
		
		Student a2 = new Student();
		a2.name = "이순신";
		a2.age = 1000;
		
		list.add(a1);
		list.add(a2);
		
		for (Student item : list) {
			// Object 말고, 상위 제네릭 써줘야 함.
			System.out.println("name = " + item.name + " / " + "age = " + item.age);			
		}
/*		
		// Student 제너릭 말고, 오브젝트 사용 시
		// Bird를 넣을 수 없는 상황이 옴.
		
		for (Object item : list) {
			Student std = (Student) item;   // item > Student 타입 캐스팅 
			System.out.println(std.name + " " + std.age);
		}
		
*/		
	
		// 제네릭 사용하는 이유 : 이 어레이리스트에 해당 타입만 넣어라고 제한하는 용도로 사용 
		// 여러 종류의 타입 사용할 경우, 오류가 뜰 때가 많아 제한해줘야 한다. 일종의 타입 지정자
/*		
		ArrayList<Integer> list = new ArrayList<>(); // 객체의 동적 배열
		int a = 33;
		
*/		// 제네릭 사용하지 않을 경우, ArrayList 값 = Object 속성 갖음 
/*		
		list.add(1234); // 제네릭을 사용하지 않는 컬렉션은 입력하는 값을 object로 Casting한다. 
		list.add(457); // 예전에는 자동적으로 지원하지 않던 기능, 타입캐스팅 해야 가능했던 기능
		list.add(1234); // () 안에 타입 구분하지 않고 다 담을 수 있음. 왜냐면 ArrayList는 객체의 속성을 갖고 있으니까
		
		
*/		// index 지정이 list.add(value); 한 순서대로 됨.
		// list.add("hello"); 		
		
		// 향상된 for문  // item 데이터 타입 초기 Object
/*		
		for(int item : list) {
			// String string = item + ""; // 값 문자
			// int number = Integer.parseInt(string); // 타입캐스팅이 이뤄지면 바뀐 타입의 메소드만 사용할 수 있
			System.out.println(item + 3);
		}
		
		// 일반 for문 
		int list_length = list.size(); // 식별자 만들어 줌.
		for(int i = 0; i < list_length; i++) {
			System.out.println(list.get(i));
		}
		*/	

		// 2. Map 계열
			// key1 : value1, key2 : value2 값의 형태로 저장됨. 
			// key가 문자열임, 숫자가 아님
			// 개인정보 같은 데이터의 경우, map 계열의 콜렉션 사용할 수 있음.
			// ArrayList와 가장 다른 점, key 값으로 String 타입을 사용할 수 있다는 점.
			// 순서 상관 없는 이유는 ArrayList의 경우, index로 분류함.
			// 하지만 Hash의 경우, key값으로 분류함.
			// 
		
		HashMap<String, String> map = new HashMap<>();
		map.put("key1", "홍길동");
		map.put("key2", "이순신");
		
		System.out.println(map.get("key1"));
		System.out.println(map.get("key2"));
		
		
		HashMap<String, Student> map1 = new HashMap<>();
		map1.put("key1", a1);
		map1.put("key2", a2);
		
		System.out.println(map1.get("key1").age);
		System.out.println(map1.get("key2").name);
	
		// 3. Set 계열
			// 리스트와 동작방식이 유사한데... 중복값을 허용하지 않는다.
			// 입력단계부터 중복을 허용하지 않음.

	
	}

}
