package at.study.redmine.model.user;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MailNotification {
    All("о всех событиях во всех проектах"),
    ONLY_MY_EVENTS("Только для обьектов, которые я отслеживаю или в которых учавствую"),
    ONLY_ASSIGNED("Только для обьектов, которые я отслеживаю или в которые мне назначены"),
    ONLY_OWNER("Только для обьектов, которые я отслеживаю или для которых я владелец"),
    NONE("Нет событий");

    private final String description;


}
