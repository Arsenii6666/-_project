package ClassroomLogin.BussnessLogic;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ClassroomLogin {
    private Map<String, ClientProfile> clientProfiles;

    public ClassroomLogin() {
        this.clientProfiles = new HashMap<>();
        ClientProfile johnDoe = new ClientProfile(1, "john_doe", "password123", "John Doe", "Example University", "student", "", new ArrayList<>());
        clientProfiles.put("john_doe", johnDoe);
    }
    public ClientProfile getClientProfileByLogin(String login, String password) {
        if (clientProfiles.containsKey(login)) {
            ClientProfile clientProfile = clientProfiles.get(login);
            if (clientProfile.getPassword().equals(password)) {
                return clientProfile;
            }
        }
        return new ClientProfile(-1, "", "", "", "", "", "", new ArrayList<>());
    }
    public void saveCourse(Course course) {
        // Логіка для збереження класу курсу в базі даних або іншому сховищі
    }
}
