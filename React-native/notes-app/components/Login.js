import React, { useEffect, useState } from "react";
import { Text,TextInput,StyleSheet,View, Button } from "react-native";
//import { AsyncStorage } from 'react-native-web/dist/index';
import AsyncStorage from "@react-native-community/async-storage";
const Login = ({navigation}) => {
    const [userName,setUserName] = useState("");
    const [Password,setPassword] = useState("");
    const [error,setError] = useState("");

    useEffect(()=>{
        isAuth()
    },[])

    const isAuth = async () => {
        // await AsyncStorage.clear()
        const username = await AsyncStorage.getItem("username");
        const password = await AsyncStorage.getItem("password");
        console.log(username+ " "+ password );
        if(username && password){
            navigation.navigate("Notes");
        }
    }

    const logged = () => {
        if(!userName){
            setError("enter a valid username");
            return;
        }
        if(!Password){
            setError("enter a valid Password");
            return;
        }
        setError("");
        AsyncStorage.setItem("username",userName);
        AsyncStorage.setItem("password",Password);
        navigation.navigate("Notes");
        console.log(userName+ " "+Password );
    }

    return (
        <View style={styles.container}>
            <Text style={styles.loginTextStyle}>
                Login
            </Text>
            <TextInput placeholder="Username" onChangeText={ (text) => setUserName(text)} style={styles.textInputStyle} />
            <TextInput placeholder="*******" onChangeText={ (text) => setPassword(text)} style={styles.textInputStyle} />
            <Text style={styles.error}>{error}</Text>
            <Button title="Login" onPress={logged} />
        </View>  
    )

}

const styles = StyleSheet.create({
    container: {
        justifyContent: "center",
        alignItems: "center",
        flex: 1
    },
    loginTextStyle: {
        fontSize: 25,
        fontWeight: "700",
        marginVertical: 20
    },
    textInputStyle: {
        borderColor: "blue",
        borderWidth: 1,
        borderRadius: 5,
        fontSize: 20,
        padding: 5,
        width: "60%",
        textAlign:"center"
    },
    error:
    {
        color:"red",
        marginBottom: 20,

    }
})

export default Login;