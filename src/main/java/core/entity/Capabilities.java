package core.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Capabilities {
    private List<Device> devices;
    private Device device;
    private String pathToMyApp;
    private String myAppPackage;
    private String myAppActivity;
}
