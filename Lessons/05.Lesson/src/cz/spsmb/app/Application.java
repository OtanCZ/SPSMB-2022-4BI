package cz.spsmb.app;

import cz.spsmb.app.conf.DatabaseConfiguration;
import cz.spsmb.app.conf.FileConfiguration;
import cz.spsmb.app.logger.ConsoleLogger;
import cz.spsmb.app.logger.DatabaseLogger;
import cz.spsmb.app.repository.DatabaseContext;
import cz.spsmb.app.repository.DatabaseUserRepository;
import cz.spsmb.app.service.SimpleUserService;
import cz.spsmb.app.service.UserService;

import javax.xml.crypto.Data;

public class Application {

    public static void main(String[] args) {
        DatabaseContext databaseContext = new DatabaseContext() {
            @Override
            public String getName() {
                return null;
            }

            @Override
            public String getPass() {
                return null;
            }

            @Override
            public String getUrl() {
                return null;
            }

            @Override
            public String getDriver() {
                return null;
            }
        };

        ConsoleLogger logger = new ConsoleLogger();
        DatabaseLogger dblog = new DatabaseLogger(databaseContext);
        dblog.openConnection();

        FileConfiguration fileConfiguration = new FileConfiguration(dblog);
        fileConfiguration.init();
        DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(logger, databaseContext);
        databaseConfiguration.openConnection();

        DatabaseUserRepository dur = new DatabaseUserRepository(logger, databaseContext, databaseConfiguration);

        UserService userService = new SimpleUserService(logger, databaseConfiguration, dur);
        userService.printCountOfUsers();

        fileConfiguration.get("dsadas");
        databaseConfiguration.get("dsadas");
    }
}
