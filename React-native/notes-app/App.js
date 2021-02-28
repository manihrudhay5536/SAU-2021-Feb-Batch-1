import React from "react";
import  { createStackNavigator} from "@react-navigation/stack";
import { NavigationContainer } from "@react-navigation/native";

import Login from "./components/Login";
import Notes from "./components/Notes";
import NoteDetails from "./components/NoteDetails";

const Stack = createStackNavigator();

const App = () => { 
  return (
    <NavigationContainer>
      <Stack.Navigator>
      <Stack.Screen name="Login" component={Login} />
      <Stack.Screen name="Notes" component={Notes} />
      <Stack.Screen name="NoteDetails" component={NoteDetails} />
      </Stack.Navigator>
    </NavigationContainer>
  )
}
 
export default App;