package Java_Day28;

public interface IAdd {
    int add(int x, int y);
}

class Main_{
    public static void main(String[] args) {
        IAdd iAdd = new IAdd(){ // 익명클래스
            @Override
            public int add(int x, int y) {
                return x+y;
            }
        };
        System.out.println(iAdd.add(3,4));

    }
}
//
//public interface IAdd {
//    int add(int x, int y);
//}
//
//class Add implements IAdd{
//    @Override
//    public int add(int x, int y){
//        return x+y;
//    }
//
//    class Main_{
//        public static void main(String[] args) {
//            IAdd iAdd = new Add();
//            System.out.println(iAdd.add(3,4));
//
//            // 어차피 한번 수행하고 버려질 클래스라면
//            // 굳이 객체를 선언하지 말고
//            // 익명클래스로 오버라이딩해서 사용하기도 했다.
//        }
//    }
//}
