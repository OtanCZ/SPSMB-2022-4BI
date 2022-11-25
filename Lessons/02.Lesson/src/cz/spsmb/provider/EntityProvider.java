package cz.spsmb.provider;

import java.util.List;

public interface EntityProvider {
    public List load(String path);

    public void save();


}
