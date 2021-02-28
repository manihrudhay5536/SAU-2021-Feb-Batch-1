import React from "react";
import { useState, useEffect } from "react";
import { StyleSheet, Text, View, ScrollView, Button } from 'react-native';
import Note from "./Note";
import AsyncStorage from "@react-native-community/async-storage";

const Notes = ({ navigation }) => {

    const update = async (id, title, desc) => {
        let change = data;
        if (change.length <= id) {
            change.push({"title": title, "desc": desc })
        }
        else {
            change[id] = {"title": title, "desc": desc };
        }


        setData(change);
        setNote();
        
    }

    const del = (id) => {
        let change = data;
        change.splice(id, 1);
        setData(change);
        setNote();
    }

    const [data, setData] = useState([]);
    const [notesList, setNotesList] = useState(data.map((note, i) => <Note del={del} update={update} data={note} navigation={navigation} id={i} key={i} />));



    useEffect(() => {
        getNotes()
    }, [])

    useEffect(() => {
        setNote()
    },[data])

    const getNotes = async () => {
        let notes = await AsyncStorage.getItem("notes");
        notes = JSON.parse(notes);
        if (notes) {
            setData(notes);
        }
    }

    const insert = (title, desc) => {
        navigation.navigate("NoteDetails", { data: {title: "", desc: "" }, update: update,id:data.length })
    }




    const setNote = async () => {
        await AsyncStorage.setItem("notes", JSON.stringify(data));
        setNotesList(data.map((note, i) => <Note del={del} update={update} data={note} navigation={navigation} id={i} key={i} />));
    }

    return (
        <View style={styles.container}>
            <View style={styles.button} >
                <Button title="Add New" style={styles.addNew}  onPress={insert} />
            </View>
            <ScrollView style={{ marginTop: 50 }}>
                {notesList.length === 0 ? <View style={styles.nonote} >
                    <Text style={styles.text} >No Notes Added</Text>
                </View> : notesList}
            </ScrollView>
        </View>
    )

}

const styles = StyleSheet.create({
    button: {marginTop: 20, marginHorizontal: 20, width: 150, height: 1,alignSelf: "flex-end", marginBottom:9,},
    nonote: {justifyContent: "center", alignItems: "center", flex: 1},
    text: { marginVertical: "70%"},
});
export default Notes;
