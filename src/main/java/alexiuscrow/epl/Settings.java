package alexiuscrow.epl;

import alexiuscrow.epl.domain.ParticipantFilterCondition;
import alexiuscrow.epl.domain.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexiuscrow on 12.09.2015.
 */
public class Settings {
    private static String appFolderName;
    private static String profileAvatarName;
    private static Profile profile;

    private static List<Long> listenedEventsIds;
    private static ParticipantFilterCondition participantFilterCondition;

    static {
        appFolderName = "epl4vk";
        profileAvatarName = "profile.jpg";
        listenedEventsIds = new ArrayList<Long>();
        listenedEventsIds.add(99994507L);
        listenedEventsIds.add(55329991L);

        participantFilterCondition = new ParticipantFilterCondition(18L, 444L, 2L);
    }

    public static List<Long> getListenedEventsIds() {
        return listenedEventsIds;
    }

    public static void setListenedEventsIds(List<Long> listenedEventsIds) {
        Settings.listenedEventsIds = listenedEventsIds;
    }

    public static ParticipantFilterCondition getParticipantFilterCondition() {
        return participantFilterCondition;
    }

    public static void setParticipantFilterCondition(ParticipantFilterCondition participantFilterCondition) {
        Settings.participantFilterCondition = participantFilterCondition;
    }

    public static String getAppFolderName() {
        return appFolderName;
    }

    public static void setAppFolderName(String appFolderName) {
        Settings.appFolderName = appFolderName;
    }

    public static String getProfileAvatarName() {
        return profileAvatarName;
    }

    public static void setProfileAvatarName(String profileAvatarName) {
        Settings.profileAvatarName = profileAvatarName;
    }

    public static Profile getProfile() {
        return profile;
    }

    public static void setProfile(Profile profile) {
        Settings.profile = profile;
    }
}
