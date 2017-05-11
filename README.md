#  클래스의 구성 멤버
## 클래스의 기본 틀
```
public class ClassName {

	// 필드 (클래스 멤버) - 객체 생성 시 호출할 필드값 저장
    // 선언 형식 식별자 선언과 동일 ex) int a; int b = 10; ...

	class ClassName {
    
    // Constructor (생성자) - 객체 생성 시 초기화 담당
    
    }
    
	public void methodName {
    
    // 객체의 동작
    
    }
}
```
### 클래스
- 직좐적인 네이밍 중요

### package (role as a directory, 일종의 폴더 같은 역할)
- naming 방법 : [domain.lang.name(method or category)]
- 패키지 안에  '*.class' 파일 넣어 저장

#####초기화 오류
- 식별자 타입은 지정되어 있는데, 초기값 자체가 없을 때 주로 발생
- 필요한 곳(로컬, 클래스 멤버 등) 초기값 설정해주면 됨



### 생성자 (return 타입 없음)
- 클래스명과 같은 이름으로 첫 글자 대문자로 명명해줘야함
- 생성자를 new를 하지 못하게 만들 수 있음 ex) 싱글톤 패턴 (single ton)
- 객체 생성 시, 초기화를 담당하는 코드 블럭
- 객체 호출 (인스턴스화) 시, 힙 영역에 올리는 것들.

```
// 인스턴스화 (클래스를 통한 객체 생성)
Fibonacci fibo = new Fibonacci();

// 생성자 호출
// 내부 로직(알고리즘)의 경우 외부로 노출되는 것을 지양하는 코딩을 해야함 (숨겨두면 됩니다.)
```

### 메소드 (Method)
- 객체의 동작을 담당하는 코드 블럭
- 일종의 기능을 구현하는 부분이라고 이해해도 됨


	public void setAge(int a){

	// 접근제어자 리턴값 이름 - 순으로 작성

	}
    
### static method 와 static 변수
- rsc 낭비를 막기 위해 정말 필요한 것만 메모리에 먼저 올려놓음
- 해제할 방법이 없음 (제어할 방법이 없음) > rsc 낭비를 야기할 수도 있기에 적절히 사용
- 클래스는 정적 변수 없음 > 클래스 자체가 static 속성을 띄고 있음
ㄴ 객체 생성 시, 바로 메모리 힙(heap) 영역에 올라가기 때문.

### 접근 제한자 (Access modifier)
- main() 메소드를 가지지 않는 대부분의 클래스는 외부 클래스에서 이용할 목적으로 설계된 라이브러리 클래스
- 객체 생성을 막기 위해 생성자를 호출하지 못하게 하거나 객체의 특정 데이터를 보호하기 위해 해당 필드에 접근하지 못하도록 제어할 필요와 특정 메소드를 호출할 수 없도록 제한할 필요가 있음
- **'접근제한자 리턴타입 함수명() {}'** 과 같이 메소드 작성
- 접근제한자 생략 시, 자동 defaul 가 붙음 (따로 표기되진 않음. 내부에서 자동 동작)
- 아래 표를 참고하면 더 자세히 알 수 있음

![](http://cfile27.uf.tistory.com/image/27689B3A5791BC1D1D35C6)
```
public class ArraySub {
	
	int a;
	public int b;
	private int c;
	
	/*
	 접근제한자 리턴타입 함수명();
	 접근제한자 써도되고 안써도
	 */
	
	// void 앞에 'default'라는 자동 접근제한자 붙
	// defalt 접근제한자 - 패키지가 다를 경우 사용할 수 없음
    // 어떤 함수를 사용할 때, 나만 사용(내 패키지 안에서)하겠다고 의도적으로 제한하고 싶을 때 적절히 사용
	// 패키지가 다를 경우에도 쓰고 싶을 때, public (모든 곳에서 접근 가능) 사용해줘야함 
	public void pirintNumber() {
		System.out.println(a);
	}
	
	// 접근제한자 default로 자동 지정되어 있는 상황
	void sum(int a, int b) {
		
		
	}
}
```

# 배열과 컬렉션 프레임워크

### Array (배열타입)
##### 배열타입을 선언하기 위한 두 가지 방법
- 먼저 배열타입 선언해줘야함
- 데이터 타입 [] 식별자 = {값1, 값2, 값3, 값4, ...};
- 데이터 타입 식별자 [] = new int[10];
 
##### 특징
- 배열변수는 참조변수에 속함
- 배열객체 선언 (후, 호출 시) > 힙 영역에 생성 > 객체 참조
- 참조할 배열 객체가 없다면 null 저장 ex) int age [] = null;
- 위의 경우 값이 없기 때문에 해당 배열에 저장되어 있는 값을 불러오거나 저장할 수 없음
ㄴ NullPointerException 발생 > 값을 생성하거나 저장해주면 해당 예외 사라짐

# 컬렉션 프레임워크 (p.722)

-  앱 개박하다 보면 다수의 객체를 저장해두고 필요할 때마다 꺼내서 사용하는 경우가 태반
-  만약 10개의 Product 객체를 저장해 두고, 필요할 때마다 하나씩 꺼내서 이용할 때, 가장 효율적이고 간단한 방법은 배열을 이용하는 것
-  배열은 쉽게 생성하고 사용할 수 있지만 저장할 수 있는 객체 수가 배열을 생성할 때 결정되기 때문에 불특정 다수의 객체를 저장하기엔 문제가 발생함
-  물론 배열의 길이를 크게 생성하면 되지만, 좋은 방법이 될 수는 없음
-  배열 값 관리에도 편리함




![](http://cfile24.uf.tistory.com/image/25299C37533F74A602E561)
- array[0] = 15; array[2] = 13;
- 이 때 [1], [3], [4]는 값이 없는 상황인데. 인덱스가 듬성듬성하기 때문에 값 관리가 어려움






### 1.List 계열
- 값이 저장되면 값을 저장한 순서대로 해당 index에 저장됨

### ArrayList
```
HashMap<generic> map = new HashMap<>();
```

- 아래 사진을 보면 조금 더 이해하기 쉬울수도 있음

![](http://www.trustingeeks.com/wp-content/uploads/2014/12/Arraylist-example-in-java.png)
- 다른 패키지는 임포트 해야함 > ArrayList의 경우 내장 패키지기 때문에 import 해야 작업하고 있는 패키지에서 이용가능하며, **JDK 내장 패키지에 있는 객체를 사용하는 것임.**
- 오브젝트 형태로 저장되기 때문에, 어떤 데이터 타입이든 다 넣을 수 있는 컬랙션 프레임워크
- 기본 입력 방식  //  .add 하는 순간 데이터 타입이 오브젝트로 변함 // 오브젝트가 갖고 있는 속성을 쓸 수 있다는 의미  // 그래서 향상된 포문을 사용할 수 없음 // 입력된 타입을 특정해줄 수 있는 방법. 제네릭!
- ArrayList에 객체를 추가하면 객체가 인덱스로 관리됨
- 배열의 길이를 지정하지 않아도 된다는 점에서 유용함

##### 자주 쓰는 메소드
- .add(value) : 배열에 값 저장
- .get(순서 파라미터) : 값출력
- .size() : 리스트 내부의 값 개수 cf) 배열타입의 'identifier.length'와 비슷한 기능
- 다른 List 메소드도 많지만 주로 현업에선 **ArrayList listName = new ArrayList();** 만 주로 사용




	public static void main(String[] args) {
		
		// 1. ArrayList 객체 생성
        ArrayList<Student> list = new ArrayList<>();
		
        // 2. Student 객체 호출 (패키지 내부에 다른 클래스 있음)
		Student a1 = new Student();
		a1.name = "홍길동";
		a1.age = 500;
		
		Student a2 = new Student();
		a2.name = "이순신";
		a2.age = 1000;
		
        // 배열에 a1 객체의 속성과 a2 객체의 속성 저장
		list.add(a1);
		list.add(a2);

_ _ _
### 주석 달린 코드

		for (Student item : list) {
			// Object 말고, ArrayList 객체 생성 시 사용했던 제네릭 써줘야 함.
			System.out.println(item.name + " " + item.age);			
		}
		
		// Student 제너릭 말고, 오브젝트 사용 시
		// Bird를 넣을 수 없는 상황이 옴. (에러 뜸)
		
        
		for (Object item : list) {
			Student std = (Student) item;   // item > Student 타입 캐스팅 
			System.out.println(std.name + " " + std.age);
		}
        
        
		
		
	
		// 제네릭 사용하는 이유 : 이 어레이리스트에 해당 타입만 넣어라고 제한하는 용도로 사용 
		// 여러 종류의 타입 사용할 경우, 오류가 뜰 때가 많아 제한해줘야 한다. 일종의 타입 지정자
		
		ArrayList<Integer> list = new ArrayList<>(); // 객체의 동적 배열
		int a = 33;
		
		// 제네릭 사용하지 않을 경우, ArrayList 값 = Object 속성 갖음 
	
		list.add(1234); // 제네릭을 사용하지 않는 컬렉션은 입력하는 값을 object로 Casting한다. 
		list.add(457); // 예전에는 자동적으로 지원하지 않던 기능, 타입캐스팅 해야 가능했던 기능
		list.add(1234); // () 안에 타입 구분하지 않고 다 담을 수 있음. 왜냐면 ArrayList는 객체의 속성을 갖고 있으니까
		
		
		// index 지정이 list.add(value); 한 순서대로 됨.
		// list.add("hello"); 		
		
		// 향상된 for문  // item 데이터 타입 초기 Object
		
		for(int item : list) {
			// String string = item + ""; // 값 문자
			// int number = Integer.parseInt(string); // 타입캐스팅이 이뤄지면 바뀐 타입의 메소드만 사용할 수 있음
			System.out.println(item + 3);
		}
		
		// 일반 for문 
		int list_length = list.size(); // 식별자 만들어 줌.
		for(int i = 0; i < list_length; i++) {
			System.out.println(list.get(i));
		}
### 2. Map

```
HashMap<key, value> map = new HashMap<key, value>();

```
- key1 : value1, key2 : value2 값의 형태로 저장됨. 
- key가 문자열임, 숫자가 아님
- 개인정보 같은 데이터의 경우, map 계열의 콜렉션 사용할 수 있음.
- ArrayList와 가장 다른 점, key 값으로 String 타입을 사용할 수 있다는 점.
- 순서 상관 없는 이유는 ArrayList의 경우, index로 분류함.
- 하지만 Hash의 경우, key값으로 분류함.


### 3. Set
```
Set<generic> set = new Set<>();
```

- 리스트와 동작방식이 유사한데... 중복값을 허용하지 않는다.
- 입력단계부터 중복을 허용하지 않음.

### 제네릭 (Generic)
- 기본타입이 아니라 참조타입. 명명해주는 것임
- 제네릭 사용하는 이유 : 이 어레이리스트에 해당 타입만 넣어라고 제한하는 용도로 사용 
- 여러 종류의 타입 사용할 경우, 오류가 뜰 때가 많아 제한해줘야 한다. 일종의 타입 지정자
- 


# secondProject
