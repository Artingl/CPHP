package lang;

public class Variables {

    private String[] variables = new String[]{""};

    public Variables()
    {

    }

    public boolean checkForExists(String name)
    {
        for (String var : variables)
        {
            if (var != null)
                if (var.equals(name)) return true;
        }

        return false;
    }

    public void addVariable(String name)
    {
        String[] newVars = new String[variables.length + 2];
        int i;
        for (i = 0; i < variables.length; i++)
        {
            newVars[i] = variables[i];
        }
        newVars[i + 1] = name;

        variables = newVars;

    }

}
