package dark.com.muslimdays.Tools;

public class Monthconvart {

    public String MonthconvartTo(String month) {
        switch (month) {

            case "Muḥarram":
                return "মুহররম";

            case "Ṣafar":
                return "সফর";

            case "Rabīʿ al-awwal":
                return "রবিউল আউয়াল";

            case "Rabīʿ al-thānī":
                return " রবিউছ ছানি";

            case "Jumādá al-ūlá":
                return "জামাদিউল আউয়াল";

            case "Jumādá al-ākhirah":
                return "জামাদিউছ ছানি";

            case "Rajab":
                return "রজব";

            case "Shaʿbān":
                return " শা’বান";

            case "Ramaḍān":
                return "রামাজান";

            case "Shawwāl":
                return "শাওয়াল";

            case "Dhū al-Qaʿdah":
                return "জুল  কাইদাহ";

            case "Dhū al-Ḥijjah":
                return "জুল হিজ্জাহ";
            case "January":
            case "jan":
                return "জানুয়ারী";

            case "February":
            case "feb":
                return "ফেব্রুয়ারি";

            case "March":
            case "mar":
                return "মার্চ";

            case "April":
            case "apr":
                return "এপ্রিল";

            case "May":
                return "মে";

            case "June":
            case "jun":
                return "জুন";

            case "July":
                return "জুলাই";

            case "August":
            case "aug":
                return "অগাস্ট";

            case "September":
            case "sep":
                return "সেপ্টেম্বর";

            case "October":
            case "oct":
                return "অক্টোবর";

            case "November":
            case "nov":
                return "নভেম্বর";

            case "December":
            case "dec":
                return "ডিসেম্বর";
            case "Sunday":
                return "রবিবার";
            case "Monday":
                return "সোমবার";
            case "Tuesday":
                return "মঙ্গলবার";
            case "Wednesday":
                return "বুধবার";
            case "Thursday":
                return "বৃহস্পতিবার";
            case "Friday":
                return "শুক্রবার";
            case "Saturday":
                return "শনিবার";
            default:
                return toString();
        }


    }

//    public char numberConverter(char bnnumber) {
//
//        switch (bnnumber) {
//            case '1':
//                return '১';
//            case '2':
//                return '২';
//            case '3':
//                return '৩';
//            case '4':
//                return '৪';
//            case '5':
//                return '৫';
//            case '6':
//                return '৬';
//            case '7':
//                return '৭';
//            case '8':
//                return '৮';
//            case '9':
//                return '৯';
//            case '0':
//                return '০';
//            default:
//                return bnnumber;
//        }
//    }


}
