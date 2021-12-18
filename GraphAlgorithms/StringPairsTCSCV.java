import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class StringPairsTCSCV {
    static HashMap<Integer, String> textRepr = new HashMap<>();
    static HashSet<Character> vowels = new HashSet<>();
    public static void main(String[] args) {
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        textRepr.put(0, "zero");
        textRepr.put(1, "one");
        textRepr.put(2, "two");
        textRepr.put(3, "three");
        textRepr.put(4, "four");
        textRepr.put(5, "five");
        textRepr.put(6, "six");
        textRepr.put(7, "seven");
        textRepr.put(8, "eight");
        textRepr.put(9, "nine");
        textRepr.put(10, "ten");
        textRepr.put(11, "eleven");
        textRepr.put(12, "twelve");
        textRepr.put(13, "thirteen");
        textRepr.put(14, "fourteen");
        textRepr.put(15, "fifteen");
        textRepr.put(16, "sixteen");
        textRepr.put(17, "seventeen");
        textRepr.put(18, "eighteen");
        textRepr.put(19, "nineteen");
        textRepr.put(20, "twenty");
        textRepr.put(21, "twentyone");
        textRepr.put(22, "twentytwo");
        textRepr.put(23, "twentythree");
        textRepr.put(24, "twentyfour");
        textRepr.put(25, "twentyfive");
        textRepr.put(26, "twentysix");
        textRepr.put(27, "twentyseven");
        textRepr.put(28, "twentyeight");
        textRepr.put(29, "twentynine");
        textRepr.put(30, "thirty");
        textRepr.put(31, "thirtyone");
        textRepr.put(32, "thirtytwo");
        textRepr.put(33, "thirtythree");
        textRepr.put(34, "thirtyfour");
        textRepr.put(35, "thirtyfive");
        textRepr.put(36, "thirtysix");
        textRepr.put(37, "thirtyseven");
        textRepr.put(38, "thirtyeight");
        textRepr.put(39, "thirtynine");
        textRepr.put(40, "forty");
        textRepr.put(41, "fortyone");
        textRepr.put(42, "fortytwo");
        textRepr.put(43, "fortythree");
        textRepr.put(44, "fortyfour");
        textRepr.put(45, "fortyfive");
        textRepr.put(46, "fortysix");
        textRepr.put(47, "fortyseven");
        textRepr.put(48, "fortyeight");
        textRepr.put(49, "fortynine");
        textRepr.put(50, "fifty");
        textRepr.put(51, "fiftyone");
        textRepr.put(52, "fiftytwo");
        textRepr.put(53, "fiftythree");
        textRepr.put(54, "fiftyfour");
        textRepr.put(55, "fiftyfive");
        textRepr.put(56, "fiftysix");
        textRepr.put(57, "fiftyseven");
        textRepr.put(58, "fiftyeight");
        textRepr.put(59, "fiftynine");
        textRepr.put(60, "sixty");
        textRepr.put(61, "sixtyone");
        textRepr.put(62, "sixtytwo");
        textRepr.put(63, "sixtythree");
        textRepr.put(64, "sixtyfour");
        textRepr.put(65, "sixtyfive");
        textRepr.put(66, "sixtysix");
        textRepr.put(67, "sixtyseven");
        textRepr.put(68, "sixtyeight");
        textRepr.put(69, "sixtynine");
        textRepr.put(70, "seventy");
        textRepr.put(71, "seventyone");
        textRepr.put(72, "seventytwo");
        textRepr.put(73, "seventythree");
        textRepr.put(74, "seventyfour");
        textRepr.put(75, "seventyfive");
        textRepr.put(76, "seventysix");
        textRepr.put(77, "seventyseven");
        textRepr.put(78, "seventyeight");
        textRepr.put(79, "seventynine");
        textRepr.put(80, "eighty");
        textRepr.put(81, "eightyone");
        textRepr.put(82, "eightytwo");
        textRepr.put(83, "eightythree");
        textRepr.put(84, "eightyfour");
        textRepr.put(85, "eightyfive");
        textRepr.put(86, "eightysix");
        textRepr.put(87, "eightyseven");
        textRepr.put(88, "eightyeight");
        textRepr.put(89, "eightynine");
        textRepr.put(90, "ninety");
        textRepr.put(91, "ninetyone");
        textRepr.put(92, "ninetytwo");
        textRepr.put(93, "ninetythree");
        textRepr.put(94, "ninetyfour");
        textRepr.put(95, "ninetyfive");
        textRepr.put(96, "ninetysix");
        textRepr.put(97, "ninetyseven");
        textRepr.put(98, "ninetyeight");
        textRepr.put(99, "ninetynine");
        textRepr.put(100, "hundred");

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];
        for(int i = 0 ; i < N; i++){
            numbers[i] = sc.nextInt();
        }
        sc.close();
        int D = 0;
        for(int t : numbers){
            D += countOfVow(t);
        }
        int twoSumCount = twoSum(numbers, D);
        if(twoSumCount > 100){
            System.out.println("greater 100");
        }
        else{
            System.out.println(textRepr.get(twoSumCount));
        }

    
    }
    public static int countOfVow(int n){
        String s = textRepr.get(n);
        int count = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                count++;
            }
        }
        return count;
    }
    public static int twoSum(int[] numbers, int D){
        HashSet<Integer> rems = new HashSet<>();
        for(int t : numbers){
            rems.add(t);
        }
        int count = 0;
        for(int i = 0 ; i < numbers.length; i++){
            if(D-numbers[i] >= 0 && rems.contains(D-numbers[i])){
                count++;
                rems.remove(numbers[i]);
                rems.remove(D-numbers[i]);
            }

            if(count > 100){
                return 101;
            }
        }
        return count;
    }
}
