Local $hIE = WinGetHandle("[Class:IEFrame]")
	Local $hCtrl = ControlGetHandle($hIE, "", "[ClassNN:DirectUIHWND1]")

	If WinExists($hIE,"") Then
		WinActivate($hIE,"")
			Sleep(700)

		ControlSend($hIE ,"",$hCtrl,"{TAB}")          ; Gives focus to Save Button
		Sleep(500)
		ControlSend($hIE ,"",$hCtrl,"{enter}")        ; Submit whatever control has focus
	EndIf
	Sleep(25000)