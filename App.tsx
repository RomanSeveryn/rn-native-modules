import React, { useEffect } from 'react';
import {
  Platform,
  SafeAreaView,
  Text,
  useColorScheme,
  View,
} from 'react-native';
import { Colors } from 'react-native/Libraries/NewAppScreen';
import TestModule from './CustomModel';

function App(): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';

  useEffect(() => {
    if (Platform.OS === 'android') {
      TestModule.show();
    }
  }, []);

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  return (
    <SafeAreaView style={backgroundStyle}>
      <View>
        <Text>Hi</Text>
      </View>
    </SafeAreaView>
  );
}

export default App;
