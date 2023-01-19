import React, { useEffect } from 'react';
import {
  NativeModules,
  Platform,
  SafeAreaView,
  Text,
  TouchableOpacity,
  View,
} from 'react-native';

function App(): JSX.Element {
  useEffect(() => {
    if (Platform.OS === 'android') {
      NativeModules.OpenActivity.open();
    }
  }, []);

  return (
    <SafeAreaView
      style={{ justifyContent: 'center', alignItems: 'center', flex: 1 }}
    >
      <View>
        <Text>Hi</Text>
        <TouchableOpacity onPress={() => NativeModules.OpenActivity.open()}>
          <Text>Open Android Activity</Text>
        </TouchableOpacity>
      </View>
    </SafeAreaView>
  );
}

export default App;
