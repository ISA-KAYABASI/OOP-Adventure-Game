public abstract class Location {

    private String locationName;
    private Player player;



    public Location(Player player) {
        this.locationName = locationName;
        this.player = player;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
