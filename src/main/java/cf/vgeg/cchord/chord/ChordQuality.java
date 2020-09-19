package cf.vgeg.cchord.chord;

public enum ChordQuality {
    MAJOR("Major", "maj"),
    MINOR("Minor", "m"),
    DOMINANT("Dominant","")
    ;

    private String fullName;
    private String shortName;

    ChordQuality(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }
    public static ChordQuality getChordQuality(String shortName){
        for (ChordQuality value : ChordQuality.values()) {
            if (value.shortName.equalsIgnoreCase(shortName)){
                return value;
            }
        }
        return null;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortName() {
        return shortName;
    }
}
