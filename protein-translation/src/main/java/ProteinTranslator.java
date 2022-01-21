import java.util.*;

class ProteinTranslator {

    Map<String, String> toProtein = new HashMap<String, String>();
    {
        toProtein.put("AUG", "Methionine");
        toProtein.put("UUU", "Phenylalanine");
        toProtein.put("UUC", "Phenylalanine");
        toProtein.put("UUA", "Leucine");
        toProtein.put("UUG", "Leucine");
        toProtein.put("UCU", "Serine");
        toProtein.put("UCC", "Serine");
        toProtein.put("UCA", "Serine");
        toProtein.put("UCG", "Serine");
        toProtein.put("UAU", "Tyrosine");
        toProtein.put("UAC", "Tyrosine");
        toProtein.put("UGU", "Cysteine");
        toProtein.put("UGC", "Cysteine");
        toProtein.put("UGG", "Tryptophan");
        toProtein.put("UAA", "STOP");
        toProtein.put("UAG", "STOP");
        toProtein.put("UGA", "STOP");
    }

    List<String> cut(String str) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < str.length(); i += 3) {
            result.add(str.substring(i, i + 3));
        }

        return result;
    }

    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<String>();
        List<String> cut = cut(rnaSequence);

        for (String codon : cut) {
            String protein = toProtein.get(codon);
            if (protein.equals("STOP")) {
                break;
            }
            result.add(protein);
        }

        return result;
    }
}
