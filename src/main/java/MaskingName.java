public class MaskingName {

    public static void main(String[] args) {

        String name = "김미정";

        System.out.println(maskName(name));

    }

    public static String maskName(String name) {
        if (name == null) {
            return "";
        }
        String maskingName;
        int nameLength = name.length();

        if (nameLength < 2) {
            maskingName = name;
        } else if (nameLength == 2) {
            maskingName = maskStrEnd(name, 1);
        } else if (nameLength == 3) {
            maskingName = maskStrMid(name, 1, 2);
        } else if (nameLength == 4) {
            maskingName = maskStrMid(name, 2, 3);
        } else {
            maskingName = maskStrMid(name, nameLength - 3, nameLength - 1);
        }

        return maskingName;
    }

//    public static String maskName(String name){
//
//        String maskingName = "";
//        int nameLength = name.length();
//
//        if(nameLength > 1){
//
//            maskingName =  maskingName.replaceAll(maskingName.substring(1),"*");
//        }
//
//
//        return maskingName;
//    }


    public static String maskStrStart(String name, int leng) {
        return (name.length() >= leng) ? makeAsterik(leng) + name.substring(name.length() - leng) : name;
    }

    public static String maskStrMid(String name, int startIdx, int endIdx) {
        return (startIdx <= endIdx && name.length() >= endIdx - startIdx) ? name.substring(0, startIdx) + makeAsterik(endIdx - startIdx) + name.substring(endIdx) : name;
    }

    public static String maskStrEnd(String name, int leng) {
        return (name.length() >= leng) ? name.substring(0, name.length() - leng) + makeAsterik(leng) : name;
    }

    public static String makeAsterik(int leng) {
        return "*".repeat(Math.max(0, leng));
    }
}
