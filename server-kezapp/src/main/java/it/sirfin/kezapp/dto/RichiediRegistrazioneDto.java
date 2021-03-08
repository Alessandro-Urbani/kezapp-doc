package it.sirfin.kezapp.dto;

public class RichiediRegistrazioneDto {

    private String nickname;

    public RichiediRegistrazioneDto() {
    }

    public RichiediRegistrazioneDto(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "RichiediRegistrazioneDto{" + "nickname=" + nickname + '}';
    }

}
